package csu.controller.membership;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import csu.payload.membership.personsacrament.PersonsacramentPayload;
import csu.services.membership.PersonsacramentService;

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

}
