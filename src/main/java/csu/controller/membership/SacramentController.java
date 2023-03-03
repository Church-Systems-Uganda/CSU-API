package csu.controller.membership;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import csu.payload.membership.ministy.MinistryPayload;
import csu.payload.membership.sacrament.SacramentPayload;
import csu.services.membership.SacramentService;

@Controller
@RequestMapping("/api/Membership")

public class SacramentController {

//create service

	@Autowired
	private SacramentService sacramentService;

	// get all the Sacaraments

	@GetMapping("/getSacraments")

//	payload

	public List<SacramentPayload> getAllSacraments() {
		return sacramentService.getAllSacraments();
	}
	
	
	
	
	
	

}
