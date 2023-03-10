package csu.controller.admin;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csu.payload.admin.affiliationHierrachy.AffiliationHierrachyPayload;
import csu.payload.admin.affiliationHierrachy.AffiliationHierrachyRequest;

import csu.services.admin.AffiliationHierrachyService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin")
public class AffiliationHierrachyController {

	
	@Autowired
	AffiliationHierrachyService  affiliationHierrachyService;
	
	@GetMapping("/affiliation_Hierrachy")
	public List<AffiliationHierrachyPayload> getAllAffiliationHierrachy() {
		return affiliationHierrachyService.getAllAffiliationHierrachy();
	}


	
	@PostMapping("/create-AffiliationHierrachy")
	public ResponseEntity<?> createAffiliationHierrachy(@Valid @RequestBody AffiliationHierrachyRequest request) {
	    return affiliationHierrachyService.createAffiliationHierrachy(request);
	}
	

	@PostMapping("/delete-AffiliationHierrachy")
	public ResponseEntity<?> deletePosition(@RequestBody AffiliationHierrachyRequest request) {

		return affiliationHierrachyService.deleteAffiliationHierrachy(request);

	}
}
