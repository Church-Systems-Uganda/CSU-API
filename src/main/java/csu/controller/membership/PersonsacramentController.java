package csu.controller.membership;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import csu.payload.membership.ministy.MinistryRequest;
import csu.payload.membership.personsacrament.PersonsacramentPayload;
import csu.payload.membership.personsacrament.PersonsacramentRequest;
import csu.services.membership.PersonsacramentService;
import jakarta.validation.Valid;

@Controller

@RequestMapping("/api/Ministry")

public class PersonsacramentController {
	
	//service
	PersonsacramentService personsacramentService;
	
	
	//create a function to get all personsacraments
	
	@GetMapping("/getPersonscraments")
	public List<PersonsacramentPayload> getAllPersonsacraments() {
		return personsacramentService.getAllPersonsacraments();
	}
	
	
	//create a fucntion to create personsacraments

	@PostMapping("/create-Personscraments")
	public ResponseEntity<?> createPersonsacrament(@Valid @RequestBody PersonsacramentRequest request) {

		return personsacramentService.createMinistry(request);

	}

	//delete function
	
    @PostMapping("/delete-ministry")
    public ResponseEntity<?> deletePersonsacrament(@RequestBody MinistryRequest request) {

	return personsacramentService.deletePersonsacrament(null);

	}
}
