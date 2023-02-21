package csu.services.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csu.model.admin.Position;
import csu.payload.admin.position.PositionPayload;
import csu.repository.admin.PositionRepository;

@Service
public class PositionService {
	
	@Autowired
	PositionRepository positionRepository;
	
	//get all services 
	
	public List<PositionPayload> getAllPositions(){
		
		List<PositionPayload> positions = new ArrayList<>();
		
		for(Position position : positionRepository.findAll()) {
			PositionPayload  payload = new PositionPayload();
			payload.setId(position.getId());
			payload.setName(position.getName());
			payload.setShortName(position.getShortName());
			
			positions.add(payload);
		}
		
		return positions;
	}

}
