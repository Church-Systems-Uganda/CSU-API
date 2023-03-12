package csu.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csu.payload.admin.affiliation.AffiliationPayload;
import csu.payload.admin.affiliation.AffiliationRequest;
import csu.services.admin.AffiliationService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin")
public class AffiliationController {

	@Autowired
	AffiliationService affiliationService;

	@GetMapping("/affiliations")
	public List<AffiliationPayload> getAllAffiliations() {
		return affiliationService.getAllAffiliations();
	}

//	@PostMapping("/create-affiliation")
//	public ResponseEntity<?> createAffliation(@Valid @RequestBody AffiliationRequest request) {
//
//		return affiliationService.createAffliation(request);
//
//	}

	@PostMapping("/delete-affiliation")
	public ResponseEntity<?> deleteAffliation(@RequestBody AffiliationRequest request) {

		return affiliationService.deleteAffliation(request);

	}

}
