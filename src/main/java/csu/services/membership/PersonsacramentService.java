package csu.services.membership;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import csu.model.membership.Personsacrament;
import csu.payload.general.ApiResponse;
import csu.payload.membership.personsacrament.PersonsacramentPayload;
import csu.payload.membership.personsacrament.PersonsacramentRequest;
import csu.repository.membership.PersonsacramentRepository;

public class PersonsacramentService {

	@Autowired
	PersonsacramentRepository personsacramentRepository;

//	get information part from a payload for the get option
	public List<PersonsacramentPayload> getAllPersonsacraments() {
		List<PersonsacramentPayload> personsacraments = new ArrayList<>();
		for (Personsacrament personsacrament : personsacramentRepository.findAll()) {

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

	// create information part for the payload
	
	// create

	public ResponseEntity<?> createMinistry(PersonsacramentRequest request) {

		if (request.getName() != null) {

			Optional<Personsacrament> existingPersonsacrament = request.getId() != null ? personsacramentRepository.findById(request.getId())
					: Optional.empty();

			if (!existingPersonsacrament.isPresent() && personsacramentRepository.existsByName(request.getName())) {
				return new ResponseEntity<>(new ApiResponse(false, "Sacrament Exists"), HttpStatus.BAD_REQUEST);
			}

			Personsacrament personsacrament = existingPersonsacrament.isPresent() ? existingPersonsacrament.get() : new Personsacrament();

			personsacrament.setName(request.getName());

			Personsacrament result = personsacramentRepository.save(personsacrament);

			if (result != null) {
				return new ResponseEntity<>(new ApiResponse(true, "Sacrament Created"), HttpStatus.OK);
			}

		}

		return new ResponseEntity<>(new ApiResponse(false, "PersonSacrament  Not Created"), HttpStatus.BAD_REQUEST);

	}
}
