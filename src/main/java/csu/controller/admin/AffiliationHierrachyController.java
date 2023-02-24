package csu.controller.admin;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csu.payload.admin.affiliationHierrachy.AffiliationHierrachyPayload;

import csu.services.admin.AffiliationHierrachyService;

@RestController
@RequestMapping("/api/admin")
public class AffiliationHierrachyController {

	
	@Autowired
	AffiliationHierrachyService  affiliationHierrachyService;
	
	@GetMapping("/affiliation_Hierrachy")
	public List<AffiliationHierrachyPayload> getAllAffiliationHierrachy() {
		return affiliationHierrachyService.getAllAffiliationHierrachy();
	}

	
}
