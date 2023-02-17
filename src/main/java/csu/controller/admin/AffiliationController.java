package csu.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csu.payload.admin.affiliation.AffiliationPayload;
import csu.services.admin.AffiliationService;

@RestController
@RequestMapping("/api/admin")
public class AffiliationController {

	@Autowired
	AffiliationService affiliationService;

	@GetMapping("/affiliations")
	public List<AffiliationPayload> getAllAffiliations() {
		return affiliationService.getAllAffiliations();
	}

}
