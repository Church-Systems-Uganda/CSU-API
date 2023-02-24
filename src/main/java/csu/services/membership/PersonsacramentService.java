package csu.services.membership;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import csu.model.membership.Personsacrament;
import csu.payload.membership.personsacrament.PersonsacramentPayload;
import csu.payload.membership.personsacrament.PersonsacramentRequest;
import csu.repository.membership.PersonsacramentRepository;

public class PersonsacramentService {
	
	@Autowired 
	PersonsacramentRepository personsacramentRepository;
	
//	get information part from a payload for the get option
	public List<PersonsacramentPayload>  getAllPersonsacraments(){
		List<PersonsacramentPayload> personsacraments = new ArrayList<>();
		for ( Personsacrament personsacrament :personsacramentRepository.findAll()) {
			
			PersonsacramentPayload personsacramentpayload = new PersonsacramentPayload();
			personsacramentpayload.setChurch(personsacrament.getChurch());
			personsacramentpayload.setDate(personsacrament.getDate());
			personsacramentpayload.setId(personsacrament.getId());
			personsacramentpayload.setName(personsacrament.getName());
			personsacramentpayload.setPerson(personsacrament.getPerson());
			personsacramentpayload.setSacrement(personsacrament.getSacrement());
			personsacramentpayload.setTier(personsacrament.getTier());
			
		personsacraments.add(personsacramentpayload);
		
		}
		return personsacraments;
	}

	//create information part for the payload
	public ResponseEntity<?> createPersonsacrament(PersonsacramentRequest request) {

		if (request.getName() != null) {

			if (personsacramentRepository.existsByName(request.getName())) {
				return new ResponseEntity<>(new ApiResponse(false, "Personsacrament Exists"), HttpStatus.BAD_REQUEST);
			}

			Optional<Personsacrament> existingPersonsacrament = request.getId() != null
					? personsacramentRepository.findById(request.getId())
					: Optional.empty();

					Personsacrament personsacrament = existingPersonsacrament.isPresent() ? existingAffliation.get()
					: new Personsacrament(request.getName(), request.getDate(), request.getTier(), request.getPerson(), request.getSacrement(), request.getChurch());


					Personsacrament result = personsacramentRepository.save(personsacrament);

			if (result != null) {
				return new ResponseEntity<>(new ApiResponse(true, "Personsacrament Created"), HttpStatus.OK);
			}

		}

		return new ResponseEntity<>(new ApiResponse(false, "Affilication Not Created"), HttpStatus.BAD_REQUEST);

	}

}
