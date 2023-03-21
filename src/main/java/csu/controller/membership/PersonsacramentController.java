package csu.controller.membership;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import csu.payload.membership.personsacrament.PersonsacramentPayload;
import csu.payload.membership.personsacrament.PersonsacramentRequest;
import csu.services.membership.PersonsacramentService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/Membership")
public class PersonsacramentController {
	
	// Autowired PersonsacramentService to handle requests
	PersonsacramentService personsacramentService;

	// Function to get all person sacraments
	@GetMapping("/getPersonscraments")
	public List<PersonsacramentPayload> getAllPersonsacraments() {
		return personsacramentService.getAllPersonsacraments();
	}
	
	// Function to create a person sacrament
	@PostMapping("/create-Personscraments")
	public ResponseEntity<?> createPersonsacrament(@Valid @RequestBody PersonsacramentRequest request) {
		return personsacramentService.createMinistry(request);
	}

	// Function to delete a person sacrament
    @PostMapping("/delete-personscraments")
    public ResponseEntity<?> deletePersonsacrament(@RequestBody PersonsacramentRequest request) {
		return personsacramentService.deletePersonsacrament(null);
	}
}
