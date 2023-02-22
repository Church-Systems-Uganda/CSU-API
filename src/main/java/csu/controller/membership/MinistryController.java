package csu.controller.membership;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import csu.payload.membership.ministy.MinistryPayload;
import csu.services.membership.MinistryService;

@Controller
@RequestMapping("/api/Ministry")
public class MinistryController {

	@Autowired
	MinistryService ministryService;

	//get all ministries

	@GetMapping("/getMinistries")
	public List<MinistryPayload> getAllMinistries() {
		return ministryService.getAllMinistries();
	}
		
	}
