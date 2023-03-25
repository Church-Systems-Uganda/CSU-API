package csu.services.financeProjects;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import csu.model.finaceProjects.ChurchIncome;
import csu.payload.financeProjects.churchIncome.ChurchIncomePayload;
import csu.payload.financeProjects.churchIncome.ChurchIncomeRequest;
import csu.payload.general.ApiResponse;
import csu.repository.financeProject.ChurchIncomeRepository;

@Service
public class ChurchIncomeService {
    
	@Autowired
	ChurchIncomeRepository churchIncomeRepository;

	// church expenditures

	public List<ChurchIncomePayload> getAllchurchIncomes() {
		List<ChurchIncomePayload> churchIncomes = new ArrayList<>();

		for (ChurchIncome churchIncome : churchIncomeRepository.findAll()) {

			ChurchIncomePayload churchIncomePayload = new ChurchIncomePayload();

			churchIncomePayload.setId(churchIncome.getId());
			churchIncomePayload.setChurch(churchIncome.getChurch());

			churchIncome.add(churchIncomePayload);
		}

		return churchIncomes;

	}

	// create church expenditures

	// delete church expenditures

	public ResponseEntity<?> deleteChurchIncome(ChurchIncomeRequest request) {

		if (request.getId() != null) {

			try {
				churchIncomeRepository.deleteById(request.getId());

				return new ResponseEntity<>(new ApiResponse(true, "Minstry Deleted"), HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		return new ResponseEntity<>(new ApiResponse(false, "Error while processing request"), HttpStatus.BAD_REQUEST);

	}

}


