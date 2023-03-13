package csu.services.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import csu.model.admin.AffiliationChurch;
import csu.model.admin.AffiliationHierrachy;
import csu.payload.admin.affiliationChurch.AffiliationChurchPayload;
import csu.payload.admin.affiliationChurch.AffiliationChurchRequest;
import csu.payload.admin.affiliationHierrachy.AffiliationHierrachyPayload;
import csu.payload.admin.affiliationHierrachy.AffiliationHierrachyRequest;
import csu.payload.general.ApiResponse;
import csu.repository.admin.AffiliationChurchRepository;

@Service
public class AffiliationChurchService {

	@Autowired
	AffiliationChurchRepository affiliationChurchRepository;

	// get all churches

//	public List<AffiliationChurchPayload> getAllChurches() {
//
//		List<AffiliationChurchPayload> church = new ArrayList<>();
//
//		for (AffiliationChurch affiliationChurch : affiliationChurchRepository.findAll()) {
//
//			AffiliationChurchPayload payload = new AffiliationChurchPayload();
//
//			payload.setId(affiliationChurch.getId());
//			payload.setAffiliationHierrachy(affiliationChurch.getAffiliationHierrachy());
//			payload.setName(affiliationChurch.getName());
//
//			church.add(payload);
//
//		}
//		return church;
//	}

	
//	// church creation
//	public ResponseEntity<?> createChurch(AffiliationChurchRequest request) {
//
//		if (request.getName() != null) {
//		
//
//			Optional<AffiliationChurch> existingAffiliationChurch = request.getId() != null
//					? affiliationChurchRepository.findById(request.getId())
//					: Optional.empty();
//
//			if (!existingAffiliationChurch.isPresent() && affiliationChurchRepository.existsByName(request.getName())) {
//				return new ResponseEntity<>(new ApiResponse(false, "church Exists"), HttpStatus.BAD_REQUEST);
//			}
//
//			AffiliationChurch affiliationChurch = existingAffiliationChurch.isPresent() ? existingAffiliationChurch.get()
//					: new AffiliationChurch();
//			
//			affiliationChurch.setName(request.getName());
//			affiliationChurch.setId(request.getId());
//			affiliationChurch.setAffiliationHierrachy(request.getAffiliationHierrachy());
//		
//					
//			AffiliationChurch result = affiliationChurchRepository.save(affiliationChurch);
//
//			if (result != null) {
//				return new ResponseEntity<>(new ApiResponse(true, "affiliationHierrachy Created"), HttpStatus.OK);
//			}
//
//		}
//
//		return new ResponseEntity<>(new ApiResponse(false, "affiliationHierrachy Not Created"), HttpStatus.BAD_REQUEST);
//
//	}

	

	// delete churches
	public ResponseEntity<?> deleteAffiliationChurch(AffiliationChurchRequest request) {

		if (request.getId() != null) {

			try {
				affiliationChurchRepository.deleteById(request.getId());

				return new ResponseEntity<>(new ApiResponse(true, "church Deleted"), HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		return new ResponseEntity<>(new ApiResponse(false, "church Not Deleted"), HttpStatus.BAD_REQUEST);

	}
}
