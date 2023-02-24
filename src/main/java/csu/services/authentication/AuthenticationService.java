package csu.services.authentication;

import java.util.Collections;

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
import csu.model.general.Person;
import csu.model.general.Role;
import csu.model.general.RoleName;
import csu.model.general.User;
import csu.payload.authentication.JwtAuthenticationResponse;
import csu.payload.authentication.LoginRequest;
import csu.payload.authentication.SignUpRequest;
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

	public ResponseEntity<?> registerUser(SignUpRequest signUpRequest) {

		/*
		 * Checking if user with the same email or username is already in the system
		 */
		if (userRepository.existsByUsername(signUpRequest.getUsername())
				|| userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity(new ApiResponse(false, "Username or Email is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		Person person = new Person(signUpRequest.getFirstname(), signUpRequest.getSurname());

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
}
