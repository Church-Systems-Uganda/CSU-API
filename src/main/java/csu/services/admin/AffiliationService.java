package csu.services.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import csu.model.admin.Affiliation;
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

		for (Affiliation affliation : affiliationRepository.findAll()) {

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

			Optional<Affiliation> existingAffliation = request.getId() != null
					? affiliationRepository.findById(request.getId())
					: Optional.empty();

			if (!existingAffliation.isPresent() && affiliationRepository.existsByName(request.getName())) {
				return new ResponseEntity<>(new ApiResponse(false, "Affilication Exists"), HttpStatus.BAD_REQUEST);
			}

			Affiliation afflition = existingAffliation.isPresent() ? existingAffliation.get()
					: new Affiliation();
			afflition.setId(request.getId());
			afflition.setName(request.getName());
			afflition.setShortName(request.getShortName());
			
			Affiliation result = affiliationRepository.save(afflition);

			if (result != null) {
				System.out.println("Affiliation created");
				return new ResponseEntity<>(new ApiResponse(true, "Affiliation Created"), HttpStatus.OK);
			}

		}
		System.out.println("Not Created created");
		return new ResponseEntity<>(new ApiResponse(false, "Affiliation Not Created"), HttpStatus.BAD_REQUEST);
		
	}

	public ResponseEntity<?> deleteAffiliation(AffiliationRequest request) {
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
	
	public ResponseEntity<?> getAffiliationById(Long id) {
	    Optional<Affiliation> optionalAffiliation = affiliationRepository.findById(id);
	    if (!optionalAffiliation.isPresent()) {
	        return new ResponseEntity<>(new ApiResponse(false, "Affiliation not found with ID: " + id), HttpStatus.NOT_FOUND);
	    }
	    Affiliation affiliation = optionalAffiliation.get();
	    AffiliationPayload affiliationPayload = new AffiliationPayload();
	    affiliationPayload.setId(affiliation.getId());
	    affiliationPayload.setName(affiliation.getName());
	    affiliationPayload.setShortName(affiliation.getShortName());
	    return new ResponseEntity<>(affiliationPayload, HttpStatus.OK);
	}


}
