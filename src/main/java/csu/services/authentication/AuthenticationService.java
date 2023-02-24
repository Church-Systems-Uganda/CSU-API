package csu.services.authentication;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import csu.exception.AppException;
import csu.model.general.Person;
import csu.model.general.Role;
import csu.model.general.RoleName;
import csu.model.general.User;
import csu.payload.authentication.SignUpRequest;
import csu.payload.general.ApiResponse;
import csu.repository.general.PersonRepository;
import csu.repository.general.RoleRepository;
import csu.repository.general.UserRepository;

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

	public ResponseEntity<?> registerUser(SignUpRequest signUpRequest) {

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

			User result = userRepository.save(user);

			if (result != null) {

				System.out.println("Saved ");
				return new ResponseEntity<>(new ApiResponse(true, "Successful"), HttpStatus.OK);
			}

		}

		return new ResponseEntity<>(new ApiResponse(true, "Not Saved"), HttpStatus.BAD_REQUEST);
	}
}
