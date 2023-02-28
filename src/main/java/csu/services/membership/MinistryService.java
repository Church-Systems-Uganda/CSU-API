package csu.services.membership;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import csu.model.membership.Ministry;

import csu.payload.general.ApiResponse;
import csu.payload.membership.ministy.MinistryPayload;
import csu.payload.membership.ministy.MinistryRequest;
import csu.repository.membership.MinistryRepository;

@Service
public class MinistryService {

	@Autowired
	MinistryRepository ministryRepository;
	
//getMinistries
	
	public List<MinistryPayload> getAllMinistries() {
		List<MinistryPayload> ministries = new ArrayList<>();

		for (Ministry ministry : ministryRepository.findAll()) {

			MinistryPayload ministryPayload = new MinistryPayload();

			ministryPayload.setId(ministry.getId());
			ministryPayload.setName(ministry.getName());
			ministryPayload.setChurch(ministry.getChurch());

			ministries.add(ministryPayload);
		}

		return ministries;

	}
	

	// create

	public ResponseEntity<?> createMinistry(MinistryRequest request) {

		if (request.getName() != null) {

			Optional<Ministry> existingMinistry = request.getId() != null ? ministryRepository.findById(request.getId())
					: Optional.empty();

			if (!existingMinistry.isPresent() && ministryRepository.existsByName(request.getName())) {
				return new ResponseEntity<>(new ApiResponse(false, "Ministry Exists"), HttpStatus.BAD_REQUEST);
			}

			Ministry ministry = existingMinistry.isPresent() ? existingMinistry.get() : new Ministry();

			ministry.setName(request.getName());

			Ministry result = ministryRepository.save(ministry);

			if (result != null) {
				return new ResponseEntity<>(new ApiResponse(true, "MinistryCreated"), HttpStatus.OK);
			}

		}

		return new ResponseEntity<>(new ApiResponse(false, "Ministry Not Created"), HttpStatus.BAD_REQUEST);

	}
	

	// delete
	public ResponseEntity<?> deleteMinistry(MinistryRequest request) {

		if (request.getId() != null) {

			try {
				ministryRepository.deleteById(request.getId());

				return new ResponseEntity<>(new ApiResponse(true, "Minstry Deleted"), HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		return new ResponseEntity<>(new ApiResponse(false, "Error while processing request"), HttpStatus.BAD_REQUEST);

	}
	
	//crude operations

	

}
