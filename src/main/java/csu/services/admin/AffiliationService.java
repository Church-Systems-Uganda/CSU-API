package csu.services.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csu.model.admin.Affliation;
import csu.payload.admin.affiliation.AffiliationPayload;
import csu.repository.admin.AffiliationRepository;

@Service
public class AffiliationService {

	@Autowired
	AffiliationRepository affiliationRepository;

	public List<AffiliationPayload> getAllAffiliations() {

		List<AffiliationPayload> affiliations = new ArrayList<>();

		for (Affliation affliation : affiliationRepository.findAll()) {

			AffiliationPayload payload = new AffiliationPayload();

			payload.setId(affliation.getId());
			payload.setName(affliation.getName());
			payload.setShortName(affliation.getShortName());

			affiliations.add(payload);

		}
		return affiliations;
	}

}
