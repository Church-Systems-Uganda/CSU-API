package csu.services.membership;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import csu.model.membership.Ministry;

import csu.payload.membership.ministy.MinistryPayload;
import csu.payload.membership.ministy.MinistryRequest;
import csu.repository.membership.MinistryRepository;
import csu.services.admin.ApiResponse;

@Service
public class MinistryService {

	@Autowired
	MinistryRepository ministryRepository;
	
	public List<MinistryPayload>  getAllMinistries(){
		List<MinistryPayload> ministries = new ArrayList<>();
		
		for(Ministry ministry :ministryRepository.findAll() ) {
			
			MinistryPayload ministryPayload = new MinistryPayload();
			
			ministryPayload.setId(ministry.getId());
			ministryPayload.setName(ministry.getName());
			ministryPayload.setChurch(ministry.getChurch());
			
			ministries.add(ministryPayload);
		}
		
		return ministries;
		
		
	}
	
	//create 
	
	public ResponseEntity<?> createMinistry(MinistryRequest request) {

		if (request.getName() != null) {

			if (ministryRepository.existsByName(request.getName())) {
				return new ResponseEntity<>(new ApiResponse(false, "Ministry Exists"), HttpStatus.BAD_REQUEST);
			}

			Optional<Ministry> existingMinistry = request.getId() != null
					? ministryRepository.findById(request.getId())
					: Optional.empty();

			Ministry ministry = existingMinistry.isPresent() ? existingMinistry.get()
					: new Ministry(request.getName(),request.getChurch());

			

			Ministry result = ministryRepository.save(ministry);

			if (result != null) {
				return new ResponseEntity<>(new ApiResponse(true, "Ministry Created"), HttpStatus.OK);
			}

		}

		return new ResponseEntity<>(new ApiResponse(false, "Ministry Not Created"), HttpStatus.BAD_REQUEST);

	}
	
	
}
