package csu.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csu.payload.admin.affiliationChurch.AffiliationChurchPayload;
import csu.payload.admin.affiliationChurch.AffiliationChurchRequest;
import csu.services.admin.AffiliationChurchService;

@RestController
@RequestMapping("/api/admin")
public class AffiliationChurchController {

	@Autowired
	AffiliationChurchService affiliationChurchService;

	@GetMapping("/church")
	public List<AffiliationChurchPayload> getAllChurches() {
		return affiliationChurchService.getAllChurches();
	}

	@PostMapping("/delete-church")
	public ResponseEntity<?> deleteChurch(@RequestBody AffiliationChurchRequest request) {

		return affiliationChurchService.deleteAffiliationChurch(request);

	}
}
