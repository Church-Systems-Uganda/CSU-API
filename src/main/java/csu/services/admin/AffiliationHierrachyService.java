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

	// create

	public ResponseEntity<?> createAffiliationHierrachy(AffiliationHierrachyRequest request) {

		if (request.getName() != null) {

			if (affiliationHierrachyRepository.existsByName(request.getName())) {
				return new ResponseEntity<>(new ApiResponse(false, "AffiliationHierrachy Exists"),
						HttpStatus.BAD_REQUEST);
			}

			Optional<AffiliationHierrachy> existingAffliation = request.getId() != null
					? affiliationHierrachyRepository.findById(request.getId())
					: Optional.empty();

			AffiliationHierrachy affiliationHierrachy = existingAffliation.isPresent() ? existingAffliation.get()
					: new AffiliationHierrachy(request.getAffliation(), request.getName(), request.getLevel(),
							request.getLevelHead());

			AffiliationHierrachy result = affiliationHierrachyRepository.save(affiliationHierrachy);

			if (result != null) {
				return new ResponseEntity<>(new ApiResponse(true, "Affilication Created"), HttpStatus.OK);
			}

		}

		return new ResponseEntity<>(new ApiResponse(false, "Affilication Not Created"), HttpStatus.BAD_REQUEST);

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
