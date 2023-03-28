package csu.controller.financeProjects;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import csu.payload.financeProjects.churchExpenditure.ChurchExpenditurePayload;
import csu.payload.financeProjects.churchExpenditure.ChurchExpenditureRequest;
import csu.services.financeProjects.ChurchExpenditureService;

@Controller
@RequestMapping("/api/financeProjects")
public class ChurchExpenditureController {
    @Autowired
	ChurchExpenditureService churchexpenditureservice;
//get all churchExpenditure

@GetMapping("/getChurchExpenditure")
public List<ChurchExpenditurePayload> getAllchurchExpenditures() {
    return churchexpenditureservice.getAllchurchExpenditures();
}


//delete function
@PostMapping("/delete-churchexpenditure")
public ResponseEntity<?> deleteChurchExpenditure(@RequestBody ChurchExpenditureRequest request) {

return churchexpenditureservice.deleteChurchExpenditure(request);

}
}
