package csu.services.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import csu.model.admin.Position;
import csu.payload.admin.affiliation.AffiliationRequest;
import csu.payload.admin.position.PositionPayload;
import csu.payload.admin.position.PositionRequest;
import csu.repository.admin.PositionRepository;
import ucu.mis.payload.ApiResponse;

@Service
public class PositionService {

	@Autowired
	PositionRepository positionRepository;

	// get all services

	public List<PositionPayload> getAllPositions() {

		List<PositionPayload> positions = new ArrayList<>();

		for (Position position : positionRepository.findAll()) {
			PositionPayload payload = new PositionPayload();
			payload.setId(position.getId());
			payload.setName(position.getName());
			payload.setShortName(position.getShortName());

			positions.add(payload);
		}

		return positions;
	}

	public ResponseEntity<?> createPosition(PositionRequest request) {
		if (request.getName() != null) {

			if (positionRepository.existsByName(request.getName())) {
				// if true
				return new ResponseEntity<>(new ApiResponse(false, "Position Exists"), HttpStatus.BAD_REQUEST);
			}
			// in case of edditing
			Optional<Position> existingPosition = request.getId() != null ? positionRepository.findById(request.getId())
					: Optional.empty();
			// get that position if present
			Position position = existingPosition.isPresent() ? existingPosition.get()
					: new Position(request.getName(), request.getShortName());
			position.setShortName(request.getShortName() != null ? request.getShortName() : null);

			// save
			Position result = positionRepository.save(position);

			if (result != null) {
				return new ResponseEntity<>(new ApiResponse(true, "Position Created"), HttpStatus.OK);
			}

		}
		return new ResponseEntity<>(new ApiResponse(false, "Error while processing request"), HttpStatus.BAD_REQUEST);
	}

	// delete Position

	public ResponseEntity<?> deletePosition(PositionRequest request) {

		if (request.getId() != null) {

			try {
				positionRepository.deleteById(request.getId());

				return new ResponseEntity<>(new ApiResponse(true, "Position Deleted"), HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		return new ResponseEntity<>(new ApiResponse(false, "Error while processing request"), HttpStatus.BAD_REQUEST);

	}
}
