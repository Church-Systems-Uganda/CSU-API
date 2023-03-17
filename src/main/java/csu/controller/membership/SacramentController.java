// Import required libraries
package csu.controller.membership;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; // Import Spring framework dependency injection library
import org.springframework.stereotype.Controller; // Import Spring framework annotation for controller
import org.springframework.web.bind.annotation.GetMapping; // Import Spring framework annotation for handling GET requests
import org.springframework.web.bind.annotation.RequestMapping; // Import Spring framework annotation for specifying request mapping

import csu.payload.membership.sacrament.SacramentPayload; 
import csu.services.membership.SacramentService; 
@Controller 
@RequestMapping("/api/Membership") // Map requests for this controller to "/api/Membership"

public class SacramentController {
	@Autowired // Use Spring dependency injection to inject the SacramentService bean
	private SacramentService sacramentService;

	@GetMapping("/getSacraments") // Map GET requests for "/api/Membership/getSacraments" to this method

	public List<SacramentPayload> getAllSacraments() { // Define method for getting all sacraments
		return sacramentService.getAllSacraments(); // Call service method to get all sacraments and return the list of payloads
	}

	
	
	

}
