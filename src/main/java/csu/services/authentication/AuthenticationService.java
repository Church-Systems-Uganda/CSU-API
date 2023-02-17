package csu.services.authentication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import csu.payload.authentication.SignUpRequest;
import ucu.mis.payload.ApiResponse;

@Service
public class AuthenticationService {

	public ResponseEntity<?> registerUser(SignUpRequest signUpRequest) {
		return new ResponseEntity<>(new ApiResponse(true, "Just Testing "), HttpStatus.OK);
	}
}
