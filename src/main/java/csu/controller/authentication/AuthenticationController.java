package csu.controller.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csu.payload.authentication.LoginRequest;
import csu.payload.authentication.SignUpRequest;
import csu.services.authentication.AuthenticationService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

	@Autowired
	AuthenticationService authenticationService;

	/*
	 * Creating a new User
	 */
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		return authenticationService.registerUser(signUpRequest);
	}

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) throws ParseException {

		return authenticationService.authenticateUser(loginRequest);

	}
}
