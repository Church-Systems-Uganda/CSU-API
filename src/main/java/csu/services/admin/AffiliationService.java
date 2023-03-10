package csu.services.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import csu.model.admin.Affliation;
import csu.payload.admin.affiliation.AffiliationPayload;
import csu.payload.admin.affiliation.AffiliationRequest;
import csu.payload.general.ApiResponse;
import csu.repository.admin.AffiliationRepository;

@Service
public class AffiliationService {

	@Autowired
	AffiliationRepository affiliationRepository;

	/*
	 * Getting all affiliations
	 */
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

	/*
	 * Creating an affiliation
	 */
	public ResponseEntity<?> createAffliation(AffiliationRequest request) {

		if (request.getName() != null) {

			Optional<Affliation> existingAffliation = request.getId() != null
					? affiliationRepository.findById(request.getId())
					: Optional.empty();

			if (!existingAffliation.isPresent() && affiliationRepository.existsByName(request.getName())) {
				return new ResponseEntity<>(new ApiResponse(false, "Affilication Exists"), HttpStatus.BAD_REQUEST);
			}

			Affliation afflition = existingAffliation.isPresent() ? existingAffliation.get()
					: new Affliation();
			
			afflition.setName(request.getName());
			afflition.setShortName(request.getShortName() != null ? request.getShortName() : null);
			
			//get AffiliationHierrachies else set to null
			afflition.setAffiliationHierrachies(request.getAffiliationHierrachies()!= null ? request.getAffiliationHierrachies(): null);
			
			Affliation result = affiliationRepository.save(afflition);

			if (result != null) {
				return new ResponseEntity<>(new ApiResponse(true, "Affilication Created"), HttpStatus.OK);
			}

		}

		return new ResponseEntity<>(new ApiResponse(false, "Affilication Not Created"), HttpStatus.BAD_REQUEST);

	}

	public ResponseEntity<?> deleteAffliation(AffiliationRequest request) {

		if (request.getId() != null) {

			try {
				affiliationRepository.deleteById(request.getId());

				return new ResponseEntity<>(new ApiResponse(true, "Affilication Deleted"), HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		return new ResponseEntity<>(new ApiResponse(false, "Affilication Not Deleted"), HttpStatus.BAD_REQUEST);

	}

}
