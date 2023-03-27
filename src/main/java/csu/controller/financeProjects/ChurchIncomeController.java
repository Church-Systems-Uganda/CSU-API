package csu.controller.financeProjects;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import csu.payload.financeProjects.churchIncome.ChurchIncomePayload;
import csu.payload.financeProjects.churchIncome.ChurchIncomeRequest;
import csu.services.financeProjects.ChurchIncomeService;


@Controller
@RequestMapping("/api/financeProjects")

public class ChurchIncomeController {
    
@Autowired
ChurchIncomeService churchincomeservice;

//logic

//get all churchIncomes

@GetMapping("/getchurchincome")

	public List<ChurchIncomePayload> getAllchurchIncomes(){
		return churchincomeservice.getAllchurchIncomes();
	}


//create and edit churchIncomes

//delete churchIncomes
@PostMapping("/delete-churchincome")
public ResponseEntity<?> deleteChurchIncome(@RequestBody ChurchIncomeRequest request) {

return churchincomeservice.deleteChurchIncome(request);

}
    
}
