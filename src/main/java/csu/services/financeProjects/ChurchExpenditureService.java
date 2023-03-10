package csu.services.financeProjects;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import csu.model.finaceProjects.ChurchExpenditure;
import csu.payload.financeProjects.churchExpenditure.ChurchExpenditurePayload;
import csu.payload.financeProjects.churchExpenditure.ChurchExpenditureRequest;
import csu.payload.general.ApiResponse;
import csu.repository.financeProject.ChurchExpenditureRepository;

public class ChurchExpenditureService {

    @Autowired
	ChurchExpenditureRepository churchExpenditureRepository;
	
    //church expenditures
	
	public List<ChurchExpenditurePayload> getAllchurchExpenditures() {
		List<ChurchExpenditurePayload> churchExpenditures = new ArrayList<>();

		for (ChurchExpenditure churchExpenditure : churchExpenditureRepository.findAll()) {

            ChurchExpenditurePayload churchExpenditurePayload = new ChurchExpenditurePayload();

			churchExpenditurePayload.setId(churchExpenditure.getId());
			churchExpenditurePayload.setChurch(churchExpenditure.getChurch());
            churchExpenditurePayload.setProject(churchExpenditure.getProject());
   
			churchExpenditure.add(churchExpenditurePayload);
		}

		return churchExpenditures;

	}

    //create church expenditures

    //delete church expenditures
   
	public ResponseEntity<?> deleteChurchExpenditure(ChurchExpenditureRequest request) {

		if (request.getId() != null) {

			try {
				churchExpenditureRepository.deleteById(request.getId());

				return new ResponseEntity<>(new ApiResponse(true, "Minstry Deleted"), HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		return new ResponseEntity<>(new ApiResponse(false, "Error while processing request"), HttpStatus.BAD_REQUEST);

	}
	
	

}
