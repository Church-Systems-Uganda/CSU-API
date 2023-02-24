package csu.services.authentication;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import csu.exception.AppException;
import csu.model.general.Role;
import csu.model.general.RoleName;
import csu.model.general.User;
import csu.payload.authentication.SignUpRequest;
import csu.repository.general.RoleRepository;
import csu.repository.general.UserRepository;
import ucu.mis.payload.ApiResponse;

@Service
public class AuthenticationService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	RoleRepository roleRepository;

	public ResponseEntity<?> registerUser(SignUpRequest signUpRequest) {
		
		System.out.println("Weclome to the Service");

		if (userRepository.existsByUsername(signUpRequest.getUsername())
				|| userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity(new ApiResponse(false, "Username or Email is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(), signUpRequest.getPassword());

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
				.orElseThrow(() -> new AppException("User Role not set."));

		//user.setRoles(Collections.singleton(userRole));
		
		System.out.println("All Set");

		User result = userRepository.save(user);

		if (result != null) {
			
			System.out.println("Saved ");
			return new ResponseEntity<>(new ApiResponse(true, "Successful"), HttpStatus.OK);
		}

		return new ResponseEntity<>(new ApiResponse(true, "Not Saved"), HttpStatus.BAD_REQUEST);
	}
}
