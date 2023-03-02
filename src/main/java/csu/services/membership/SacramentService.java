package csu.services.membership;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import csu.model.membership.Sacrament;
import csu.payload.general.ApiResponse;
import csu.payload.membership.sacrament.SacramentPayload;
import csu.payload.membership.sacrament.SacramentRequest;
import csu.repository.membership.SacramentRepository;

@Service
public class SacramentService {
	@Autowired
	SacramentRepository sacramentRepository;
	
//	get information part from a payload for the get option
	
	
	public List<SacramentPayload>  getAllSacraments(){
		List<SacramentPayload> sacraments = new ArrayList<>();
		
		for ( Sacrament sacrament :sacramentRepository.findAll()) {
			
			SacramentPayload sacramentpayload = new SacramentPayload();
			
			sacramentpayload.setAffliation(sacrament.getAffliation());
			sacramentpayload.setId(sacrament.getId());
			sacramentpayload.setName(sacrament.getName());
			sacramentpayload.setPrerequisite(sacrament.getPrerequisite());
			sacramentpayload.setTier(sacrament.getTier());
			
			sacraments.add(sacramentpayload);
			
		}
		return sacraments;
		}
	
	//create information part for the payload
	// create

	public ResponseEntity<?> createSacrament(SacramentRequest request) {

		if (request.getName() != null) {

			Optional<Sacrament> existingSacrament = request.getId() != null ? sacramentRepository.findById(request.getId())
					: Optional.empty();

			if (!existingSacrament.isPresent() && sacramentRepository.existsByName(request.getName())) {
				return new ResponseEntity<>(new ApiResponse(false, "Sacrament Exists"), HttpStatus.BAD_REQUEST);
			}

			Sacrament sacrament = existingSacrament.isPresent() ? existingSacrament.get() : new Sacrament();

			sacrament.setName(request.getName());

			Sacrament result = sacramentRepository.save(sacrament);

			if (result != null) {
				return new ResponseEntity<>(new ApiResponse(true, "SacramentCreated"), HttpStatus.OK);
			}

		}

		return new ResponseEntity<>(new ApiResponse(false, "Sacrament Not Created"), HttpStatus.BAD_REQUEST);

	}
	

	

}
