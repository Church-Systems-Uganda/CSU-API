package csu.services.membership;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import csu.model.membership.Ministry;
import csu.model.membership.Personsacrament;
import csu.payload.general.ApiResponse;
import csu.payload.membership.ministy.MinistryPayload;
import csu.payload.membership.personsacrament.PersonsacramentPayload;
import csu.payload.membership.personsacrament.PersonsacramentRequest;
import csu.repository.membership.PersonsacramentRepository;

public class PersonsacramentService {

	@Autowired
	PersonsacramentRepository personsacramentRepository;

	// Get all person sacraments
	public List<PersonsacramentPayload> getAllPersonsacraments() {
		List<PersonsacramentPayload> personsacraments = new ArrayList<>();
		for (Personsacrament personsacrament : personsacramentRepository.findAll()) {

			// Create a new PersonsacramentPayload object for each record and populate it with data from the Personsacrament entity
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

	// Create or update a person sacrament record
	public ResponseEntity<?> createMinistry(PersonsacramentRequest request) {

		if (request.getName() != null) {

			// Check if a record with the same name already exists in the database
			Optional<Personsacrament> existingPersonsacrament = request.getId() != null ? personsacramentRepository.findById(request.getId())
					: Optional.empty();

			if (!existingPersonsacrament.isPresent() && personsacramentRepository.existsByName(request.getName())) {
				// If a record with the same name exists and we're not updating an existing record, return a bad request status
				return new ResponseEntity<>(new ApiResponse(false, "Sacrament Exists"), HttpStatus.BAD_REQUEST);
			}

			// Create a new Personsacrament object if we're not updating an existing record, otherwise use the existing record
			Personsacrament personsacrament = existingPersonsacrament.isPresent() ? existingPersonsacrament.get() : new Personsacrament(null, null, null, null, null, null);

			// Update the Personsacrament object with data from the request payload
			personsacrament.setName(request.getName());
			personsacrament.setChurch(request.getChurch());
			personsacrament.setDate(request.getDate());
			personsacrament.setSacrement(request.getSacrement());
			personsacrament.setPerson(request.getPerson());
			personsacrament.setTier(request.getTier());
			

			//

			

			Personsacrament result = personsacramentRepository.save(personsacrament);

			if (result != null) {
				return new ResponseEntity<>(new ApiResponse(true, "Sacrament Created"), HttpStatus.OK);
			}

		}

		return new ResponseEntity<>(new ApiResponse(false, "PersonSacrament  Not Created"), HttpStatus.BAD_REQUEST);

	}

	// delete
	public ResponseEntity<?> deletePersonsacrament(PersonsacramentRequest request) {

		if (request.getId() != null) {

			try {
				personsacramentRepository.deleteById(request.getId());

				return new ResponseEntity<>(new ApiResponse(true, "Sacrament Deleted"), HttpStatus.OK);
			} catch (Exception e) {
				
			}

		}

		return new ResponseEntity<>(new ApiResponse(false, "Error while processing request"), HttpStatus.BAD_REQUEST);

	}
	
	// find Personsacrament  by id
	
		public ResponseEntity<?> getPersonsacramentById(Long id) {
		    Optional<Personsacrament> optionalPersonsacrament = personsacramentRepository.findById(id);
		    if (!optionalPersonsacrament.isPresent()) {
		        return new ResponseEntity<>(new ApiResponse(false, "Personsacrament not found with ID: " + id), HttpStatus.NOT_FOUND);
		    }
		    Personsacrament personsacrament = optionalPersonsacrament.get();
		    PersonsacramentPayload personsacramentPayload = new PersonsacramentPayload();
		    personsacramentPayload.setId(personsacrament.getId());
		   
		    return new ResponseEntity<>(personsacramentPayload, HttpStatus.OK);
		}
}
