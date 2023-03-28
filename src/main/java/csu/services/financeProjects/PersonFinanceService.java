package csu.services.financeProjects;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import csu.model.finaceProjects.PersonFinance;
import csu.payload.financeProjects.personFinance.PersonFinancePayload;
import csu.payload.financeProjects.personFinance.PersonFinanceRequest;
import csu.payload.general.ApiResponse;
import csu.repository.financeProject.PersonFinanceRepository;

@Service
public class PersonFinanceService {
	
	@Autowired
	PersonFinanceRepository personFinanceRepository;

	// church expenditures

	public List<PersonFinancePayload> getAllpersonFinances() {
		List<PersonFinancePayload> personFinances = new ArrayList<>();

		for (PersonFinance personFinance : personFinanceRepository.findAll()) {

			PersonFinancePayload personFinancePayload = new PersonFinancePayload();

			personFinancePayload.setId(personFinance.getId());
			personFinancePayload.setChurch(personFinance.getChurch());
			personFinancePayload.setPerson(personFinance.getPerson());

			personFinance.add(personFinancePayload);
		}

		return personFinances;

	}

	// create church expenditures

	// delete church expenditures

	public ResponseEntity<?> deletepersonfinance(PersonFinanceRequest request) {

		if (request.getId() != null) {

			try {
				personFinanceRepository.deleteById(request.getId());

				return new ResponseEntity<>(new ApiResponse(true, "Minstry Deleted"), HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		return new ResponseEntity<>(new ApiResponse(false, "Error while processing request"), HttpStatus.BAD_REQUEST);

	}


}
