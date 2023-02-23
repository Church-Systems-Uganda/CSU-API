package csu.services.membership;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import csu.model.membership.Sacrament;
import csu.payload.membership.sacrament.SacramentPayload;

import csu.repository.membership.SacramentRepository;

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
	

}
