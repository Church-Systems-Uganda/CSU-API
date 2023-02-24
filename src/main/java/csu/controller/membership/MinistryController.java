package csu.controller.membership;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import csu.payload.admin.affiliation.AffiliationRequest;
import csu.payload.membership.ministy.MinistryPayload;
import csu.payload.membership.ministy.MinistryRequest;
import csu.services.membership.MinistryService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/Ministry")
public class MinistryController {

	@Autowired
	MinistryService ministryService;

	//get all ministriy

	@GetMapping("/getMinistries")
	public List<MinistryPayload> getAllMinistries() {
		return ministryService.getAllMinistries();
	}
	
	//post mapping to create
	
	@PostMapping("/create-ministry")
	public ResponseEntity<?> createMinistry(@Valid @RequestBody MinistryRequest request) {

		return ministryService.createMinistry(request);

	}
	//delete function
	@PostMapping("/delete-ministry")
	public ResponseEntity<?> deleteMinistry(@RequestBody MinistryRequest request) {

		return ministryService.deleteMinistry(request);

	}
	
		
	}
