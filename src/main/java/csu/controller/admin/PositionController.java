package csu.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csu.payload.admin.affiliation.AffiliationRequest;
import csu.payload.admin.position.PositionPayload;
import csu.payload.admin.position.PositionRequest;
import csu.services.admin.PositionService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin")
public class PositionController {
	
	@Autowired
	PositionService  positionService;

	/**
	 * Get a list of all positions
	 * @return a list of PositionPayload objects representing the positions
	 */
	@GetMapping("/positions")
	public List<PositionPayload> getAllPositions() {
		return positionService.getAllPositions();
	}

	// This endpoint is currently not in use, so it's been commented out
//	@PostMapping("/create-position")
//	public ResponseEntity<?> createPosition(@Valid @RequestBody PositionRequest request){
//		
//		return positionService.createPosition(request);
//	}
	
	/**
	 * Delete a position
	 * @param request a PositionRequest object containing the id of the position to be deleted
	 * @return a ResponseEntity with the appropriate status code
	 */
	@PostMapping("/delete-position")
	public ResponseEntity<?> deletePosition(@RequestBody PositionRequest request) {
		return positionService.deletePosition(request);
	}

}
