package csu.controller.membership;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import csu.payload.membership.ministy.MinistryPayload;
import csu.payload.membership.sacrament.SacramentPayload;
import csu.payload.membership.sacrament.SacramentRequest;
import csu.services.membership.SacramentService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/Ministry")

public class SacramentController {

//create service

	@Autowired
	private SacramentService sacramentService;

	// get all the Sacaraments

	@GetMapping("/getSacraments")

//	payload

	public List<SacramentPayload> getAllSacraments() {
		return sacramentService.getAllSacraments();
	}
	
	
	
	
	
	


	//post mapping to create
	
	@PostMapping("/create-ministry")
	public ResponseEntity<?> createSacrament(@Valid @RequestBody SacramentRequest request) {

		return sacramentService.createSacrament(request);

	}
	
}
