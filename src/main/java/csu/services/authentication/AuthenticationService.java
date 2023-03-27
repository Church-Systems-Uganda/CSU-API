package csu.services.authentication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import csu.exception.AppException;
import csu.model.admin.Affiliation;
import csu.model.finaceProjects.ChurchExpenditure;
import csu.model.general.Person;
import csu.model.general.Role;
import csu.model.general.RoleName;
import csu.model.general.User;
import csu.payload.admin.affiliation.AffiliationPayload;
import csu.payload.authentication.GetAllUsersPayload;
import csu.payload.authentication.JwtAuthenticationResponse;
import csu.payload.authentication.LoginRequest;
import csu.payload.authentication.SignUpRequest;
import csu.payload.financeProjects.churchExpenditure.ChurchExpenditurePayload;
import csu.payload.general.ApiResponse;
import csu.repository.general.PersonRepository;
import csu.repository.general.RoleRepository;
import csu.repository.general.UserRepository;
import csu.security.JwtTokenProvider;

@Service
public class AuthenticationService {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenProvider tokenProvider;
	
	public List<GetAllUsersPayload> getAllusers() {
		
		List<GetAllUsersPayload> users = new ArrayList<>();
		
		for (User user : userRepository.findAll()){
			
			GetAllUsersPayload getuser = new GetAllUsersPayload();
			getuser.setEmail(user.getEmail());
			getuser.setUsername(user.getUsername());
		
			users.add(getuser);
		}
		return users;
	}

	public ResponseEntity<?> registerUser(SignUpRequest signUpRequest) {

		/*
		 * Checking if user with the same email or username is already in the system
		 */
		if (userRepository.existsByUsername(signUpRequest.getUsername())
				|| userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity(new ApiResponse(false, "Username or Email is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		Person person = new Person(signUpRequest.getFirstname(), signUpRequest.getSurname(), null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
				null);

		Person savedPerson = personRepository.save(person);

		if (savedPerson != null) {

			User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail());

			user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

			Role userRole = roleRepository
					.findByName(signUpRequest.getRoleName() != null ? signUpRequest.getRoleName() : RoleName.ROLE_USER)
					.orElseThrow(() -> new AppException("User Role not set."));

			user.setRoles(Collections.singleton(userRole));
			user.setPerson(savedPerson);

			User result = null;

			try {
				result = userRepository.save(user);
			} catch (Exception e) {
				// TODO: handle exception
			}

			if (result != null) {

				return new ResponseEntity<>(new ApiResponse(true, "Successful"), HttpStatus.OK);
			} else {
				personRepository.delete(savedPerson);

				return new ResponseEntity<>(new ApiResponse(true, "Didnt save User therefore deleted person"),
						HttpStatus.BAD_REQUEST);
			}

		}

		return new ResponseEntity<>(new ApiResponse(true, "Not Saved"), HttpStatus.BAD_REQUEST);
	}

	/*
	 * Authenticate User
	 */
	public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(authentication);

		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));

	}

	
	public ResponseEntity<?> getUserById(Long id) {
	    Optional<User> optionalUser = userRepository.findById(id);
	    if (!optionalUser.isPresent()) {
	        return new ResponseEntity<>(new ApiResponse(false, "User not found with id: " + id), HttpStatus.NOT_FOUND);
	    }
	    User user = optionalUser.get();
	    
	    return new ResponseEntity<>(new ApiResponse(false, "User results present"), HttpStatus.OK);

	}
	public ResponseEntity<?> getUserByUsername(String username) {
	    Optional<User> optionalUser = userRepository.findByUsername(username);
	    if (!optionalUser.isPresent()) {
	        return new ResponseEntity<>(new ApiResponse(false, "User not found with username: " + username), HttpStatus.NOT_FOUND);
	    }
	    User user = optionalUser.get();
	    
	    return new ResponseEntity<>(new ApiResponse(false, "User results present"), HttpStatus.OK);
	}

	
}
