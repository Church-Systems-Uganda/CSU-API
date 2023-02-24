package csu.services.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import csu.model.admin.AffiliationHierrachy;
import csu.model.admin.Affliation;
import csu.payload.admin.affiliation.AffiliationPayload;
import csu.payload.admin.affiliation.AffiliationRequest;
import csu.payload.admin.affiliationHierrachy.AffiliationHierrachyPayload;
import csu.payload.admin.affiliationHierrachy.AffiliationHierrachyRequest;
import csu.repository.admin.AffiliationHierrachyRepository;

@Service
public class AffiliationHierrachyService {

	
	@Autowired
	AffiliationHierrachyRepository  affiliationHierrachyRepository;
	
	 
	public List<AffiliationHierrachyPayload> getAllAffiliationHierrachy() {

		List<AffiliationHierrachyPayload> affiliations= new ArrayList<>();

		for (AffiliationHierrachy affiliationHierrachy :  affiliationHierrachyRepository.findAll()) {

			AffiliationHierrachyPayload payload = new AffiliationHierrachyPayload();

			payload.setId(affiliationHierrachy.getId());
			payload.setLevelHead(affiliationHierrachy.getLevelHead());
			payload.setLevel(affiliationHierrachy.getLevel());
			payload.setName(affiliationHierrachy.getName());
			

			affiliations.add(payload);

		}
		return affiliations;
	}

	


	
}
