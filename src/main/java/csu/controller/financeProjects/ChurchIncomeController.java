package csu.controller.financeProjects;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import csu.payload.financeProjects.churchIncome.ChurchIncomePayload;
import csu.services.financeProjects.ChurchIncomeService;


@Controller
@RequestMapping("/api/financeProjects")

public class ChurchIncomeController {
    
@Autowired
ChurchIncomeService churchincomeservice;

//logic

//get all projects

@GetMapping("/getchurchincome")

	public List<ChurchIncomePayload> getAllchurchIncomes(){
		return churchincomeservice.getAllchurchIncomes();
	}


//create and edit projects

//delete project

    
}
