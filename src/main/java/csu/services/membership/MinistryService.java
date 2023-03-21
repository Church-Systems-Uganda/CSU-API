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
	MinistryRepository ministryRepository; // inject MinistryRepository instance into service

	// retrieve all ministries and map them to MinistryPayload objects
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

	// create a new ministry
	public ResponseEntity<?> createMinistry(MinistryRequest request) {
		if (request.getName() != null) {
			Optional<Ministry> existingMinistry = request.getId() != null
					? ministryRepository.findById(request.getId())
					: Optional.empty();

			// check if ministry with the same name already exists
			if (!existingMinistry.isPresent() && ministryRepository.existsByName(request.getName())) {
				return new ResponseEntity<>(new ApiResponse(false, "Ministry Exists"), HttpStatus.BAD_REQUEST);
			}

			Ministry ministry = existingMinistry.isPresent() ? existingMinistry.get() : new Ministry();

			ministry.setName(request.getName());

			Ministry result = ministryRepository.save(ministry);

			// return success response if ministry is created
			if (result != null) {
				return new ResponseEntity<>(new ApiResponse(true, "MinistryCreated"), HttpStatus.OK);
			}
		}

		// return error response if ministry is not created
		return new ResponseEntity<>(new ApiResponse(false, "Ministry Not Created"), HttpStatus.BAD_REQUEST);
	}

	// delete a ministry by its ID
	public ResponseEntity<?> deleteMinistry(MinistryRequest request) {
		if (request.getId() != null) {
			try {
				ministryRepository.deleteById(request.getId());

				// return success response if ministry is deleted
				return new ResponseEntity<>(new ApiResponse(true, "Minstry Deleted"), HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		// return error response if ministry is not deleted
		return new ResponseEntity<>(new ApiResponse(false, "Error while processing request"), HttpStatus.BAD_REQUEST);
	}

	// additional CRUD operations can be added here
}
