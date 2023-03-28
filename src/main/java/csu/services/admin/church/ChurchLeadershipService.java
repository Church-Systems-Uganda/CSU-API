package csu.services.admin.church;


import csu.model.admin.Church.ChurchLeadership;
import csu.payload.admin.ChurchLeadership.ChurchLeadershipPayload;
import csu.payload.admin.ChurchLeadership.ChurchLeadershipRequest;

import csu.payload.general.ApiResponse;
import csu.repository.admin.Church.ChurchLeadershipRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChurchLeadershipService {

    @Autowired
    ChurchLeadershipRepository churchLeadershipRepository;

    public List<ChurchLeadershipPayload> getAllChurchLeaderships() {
        List<ChurchLeadershipPayload> churchLeadershipPayload = new ArrayList<>();
        
        for (ChurchLeadership churchLeadership : churchLeadershipRepository.findAll()) {

			ChurchLeadershipPayload payload = new ChurchLeadershipPayload();
			payload.setId(churchLeadership.getId());
			payload.setMinistry(churchLeadership.getMinistry());
			payload.setChurchHierrachy(churchLeadership.getChurchHierrachy());


			churchLeadershipPayload.add(payload);
		}

		return churchLeadershipPayload;
    }

 // create
	
 	public ResponseEntity<?> createChurchLeadership(ChurchLeadershipRequest request) {

 		if (request.getId() != null) {

 			Optional<ChurchLeadership> existingchurchLeadership = request.getId() != null
 					? churchLeadershipRepository.findById(request.getId())
 					: Optional.empty();

 			if (!existingchurchLeadership.isPresent() && churchLeadershipRepository.existsById(request.getId())) {
 				return new ResponseEntity<>(new ApiResponse(false, "churchLeadership Exists"), HttpStatus.BAD_REQUEST);
 			}

 			ChurchLeadership churchLeadership = existingchurchLeadership.isPresent() ? existingchurchLeadership.get()
 					: new ChurchLeadership();
 			
 			churchLeadership.setId(request.getId());
 			

 			ChurchLeadership result = churchLeadershipRepository.save(churchLeadership);

 			if (result != null) {
 				return new ResponseEntity<>(new ApiResponse(true, "churchLeadership Created"), HttpStatus.OK);
 			}

 		}

 		return new ResponseEntity<>(new ApiResponse(false, "churchLeadership Not Created"), HttpStatus.BAD_REQUEST);

 	}

 	
 	// delete

 	public ResponseEntity<?> deleteChurchLeadership(ChurchLeadershipRequest request) {

 		if (request.getId() != null) {

 			try {
 				churchLeadershipRepository.deleteById(request.getId());

 				return new ResponseEntity<>(new ApiResponse(true, "ChurchLeadership Deleted"), HttpStatus.OK);
 			} catch (Exception e) {
 				// TODO: handle exception
 			}

 		}

 		return new ResponseEntity<>(new ApiResponse(false, "ChurchLeadership Not Deleted"), HttpStatus.BAD_REQUEST);

 	}

 }

    