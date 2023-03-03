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
import csu.model.admin.Church.ChurchHierrachy;
import csu.payload.admin.affiliation.AffiliationPayload;
import csu.payload.admin.affiliation.AffiliationRequest;
import csu.payload.admin.affiliationHierrachy.AffiliationHierrachyPayload;
import csu.payload.admin.affiliationHierrachy.AffiliationHierrachyRequest;
import csu.payload.admin.churchHierrachy.ChurchHierrachyRequest;
import csu.payload.general.ApiResponse;
import csu.repository.admin.AffiliationHierrachyRepository;

@Service
public class AffiliationHierrachyService {

	@Autowired
	AffiliationHierrachyRepository affiliationHierrachyRepository;

	public List<AffiliationHierrachyPayload> getAllAffiliationHierrachy() {

		List<AffiliationHierrachyPayload> affiliations = new ArrayList<>();

		for (AffiliationHierrachy affiliationHierrachy : affiliationHierrachyRepository.findAll()) {

			AffiliationHierrachyPayload payload = new AffiliationHierrachyPayload();

			payload.setId(affiliationHierrachy.getId());
			payload.setLevelHead(affiliationHierrachy.getLevelHead());
			payload.setLevel(affiliationHierrachy.getLevel());
			payload.setName(affiliationHierrachy.getName());

			affiliations.add(payload);

		}
		return affiliations;
	}

	public ResponseEntity<?> createAffiliationHierrachy(AffiliationHierrachyRequest request) {

		if (request.getName() != null) {
			System.out.println(" not empty");

			Optional<AffiliationHierrachy> existingffiliationHierrachy = request.getId() != null
					? affiliationHierrachyRepository.findById(request.getId())
					: Optional.empty();

			if (!existingffiliationHierrachy.isPresent() && affiliationHierrachyRepository.existsByName(request.getName())) {
				return new ResponseEntity<>(new ApiResponse(false, "churchHierrachy Exists"), HttpStatus.BAD_REQUEST);
			}

			AffiliationHierrachy affiliationHierrachy = existingffiliationHierrachy.isPresent() ? existingffiliationHierrachy.get()
					: new AffiliationHierrachy( );
			
			affiliationHierrachy.setId(request.getId());
			affiliationHierrachy.setAffliation(request.getAffliation());
			affiliationHierrachy.setName(request.getName());
			affiliationHierrachy.setLevel(request.getLevel());
			affiliationHierrachy.setLevelHead(request.getLevelHead());
			
			AffiliationHierrachy result = affiliationHierrachyRepository.save(affiliationHierrachy);

			if (result != null) {
				System.out.println(" saved");
				return new ResponseEntity<>(new ApiResponse(true, "affiliationHierrachy Created"), HttpStatus.OK);
			}

		}

		return new ResponseEntity<>(new ApiResponse(false, "affiliationHierrachy Not Created"), HttpStatus.BAD_REQUEST);

	}

	
	// delete

	public ResponseEntity<?> deleteAffiliationHierrachy(AffiliationHierrachyRequest request) {

		if (request.getId() != null) {

			try {
				affiliationHierrachyRepository.deleteById(request.getId());

				return new ResponseEntity<>(new ApiResponse(true, "affiliationHierrachy Deleted"), HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		return new ResponseEntity<>(new ApiResponse(false, "affiliationHierrachy Not Deleted"), HttpStatus.BAD_REQUEST);

	}

}
