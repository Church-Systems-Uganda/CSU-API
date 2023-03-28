package csu.controller.financeProjects;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import csu.payload.financeProjects.personFinance.PersonFinancePayload;
import csu.payload.financeProjects.personFinance.PersonFinanceRequest;
import csu.services.financeProjects.PersonFinanceService;

@Controller
@RequestMapping("/api/financeProjects")
public class PersonFinanceController {
	
	@Autowired
	PersonFinanceService personfinanceservice;
//get all personfinance

@GetMapping("/getpersonfinance")
public List<PersonFinancePayload> getAllpersonFinances() {
    return personfinanceservice.getAllpersonFinances();
}


//delete function
@PostMapping("/delete-personfinance")
public ResponseEntity<?> deletepersonfinance(@RequestBody PersonFinanceRequest request) {

return personfinanceservice.deletepersonfinance(request);

}

}
