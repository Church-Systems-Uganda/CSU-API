package csu.controller.membership;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import csu.payload.membership.ministy.MinistryPayload;
import csu.payload.membership.ministy.MinistryRequest;
import csu.services.membership.MinistryService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/Membership")
public class MinistryController {

	@Autowired
	MinistryService ministryService; // inject MinistryService instance into controller

	// handle HTTP GET request to retrieve all ministries
	@GetMapping("/getMinistries")
	public List<MinistryPayload> getAllMinistries() {
		return ministryService.getAllMinistries(); // delegate to ministryService to retrieve all ministries
	}
	
	// handle HTTP POST request to create a new ministry
	@PostMapping("/create-ministry")
	public ResponseEntity<?> createMinistry(@Valid @RequestBody MinistryRequest request) {
		return ministryService.createMinistry(request); // delegate to ministryService to create a new ministry
	}
	
	// handle HTTP POST request to delete a ministry
	@DeleteMapping("/delete-ministry")
	public ResponseEntity<?> deleteMinistry(@RequestBody MinistryRequest request) {
		return ministryService.deleteMinistry(request); // delegate to ministryService to delete a ministry
	}
	
	//get affiliation by id
  	@GetMapping("/get_ministry/{id}")
      public ResponseEntity<?> getMinistryById(@org.springframework.web.bind.annotation.PathVariable("id") Long id) {
          ResponseEntity<?> ministry = ministryService.getMinistryById(id);

          return new ResponseEntity<>(ministry, HttpStatus.OK);
      }
	
}
