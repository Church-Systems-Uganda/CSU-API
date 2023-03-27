package csu.controller.authentication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csu.payload.authentication.GetAllUsersPayload;
import csu.payload.authentication.LoginRequest;
import csu.payload.authentication.SignUpRequest;
import csu.services.authentication.AuthenticationService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

	@Autowired
	AuthenticationService authenticationService;

	
	//getting user
	
	 @GetMapping("/GetAllUsers")
	  public List<GetAllUsersPayload> getAllusers() {
	      return authenticationService.getAllusers();
	  }
	 
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
	
	//get user by id 
   
	@GetMapping("/Users/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
	    return authenticationService.getUserById(id);
	}
	
	@GetMapping("/Users/{username}")
	public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
	    return authenticationService.getUserByUsername(username);
	}

	
}
