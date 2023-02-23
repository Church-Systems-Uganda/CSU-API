package csu.services.membership;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import csu.model.membership.Personsacrament;
import csu.payload.membership.personsacrament.PersonsacramentPayload;

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
}
