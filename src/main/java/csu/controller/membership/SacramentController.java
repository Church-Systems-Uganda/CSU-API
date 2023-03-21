// Import required libraries
package csu.controller.membership;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; // Import Spring framework dependency injection library
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller; // Import Spring framework annotation for controller
import org.springframework.web.bind.annotation.GetMapping; // Import Spring framework annotation for handling GET requests
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; // Import Spring framework annotation for specifying request mapping

import csu.payload.membership.sacrament.SacramentPayload;
import csu.payload.membership.sacrament.SacramentRequest;
import csu.services.membership.SacramentService;
import jakarta.validation.Valid; 
@Controller 
@RequestMapping("/api/Membership") // Map requests for this controller to "/api/Membership"

public class SacramentController {
	
	@Autowired // Use Spring dependency injection to inject the SacramentService bean
	private SacramentService sacramentService;
	
	
	// handle HTTP POST request to get Sacrament
	@GetMapping("/getSacraments") // Map GET requests for "/api/Membership/getSacraments" to this method

	public List<SacramentPayload> getAllSacraments() { // Define method for getting all sacraments
		return sacramentService.getAllSacraments(); // Call service method to get all sacraments and return the list of payloads
	}
	
	
	// handle HTTP POST request to create a new Sacrament
		@PostMapping("/create-sacraments")
		public ResponseEntity<?> createSacrament(@Valid @RequestBody SacramentRequest request) {
			return sacramentService.createSacrament(request); // delegate to SacramentService to create a new ministry
		}
		
		
	// handle HTTP POST request to delete a Sacrament
		@PostMapping("/delete-sacraments")
		public ResponseEntity<?> deleteSacrament(@RequestBody SacramentRequest request) {
			return sacramentService.deleteSacrament(request); // delegate to SacramentService to delete a ministry
		}
	
	
	

}
