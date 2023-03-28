package csu.services.admin.church;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import csu.model.admin.Church.ChurchHierrachy;
import csu.model.admin.Church.PersonChurch;
import csu.payload.admin.PersonChurch.PersonChurchPayload;
import csu.payload.admin.PersonChurch.PersonChurchRequest;
import csu.payload.admin.churchHierrachy.ChurcHierrachyPayload;
import csu.payload.admin.churchHierrachy.ChurchHierrachyRequest;
import csu.payload.general.ApiResponse;
import csu.repository.admin.Church.ChurchHierrachyRepository;
import csu.repository.admin.Church.PersonChurchRepository;

@Service
public class PersonChurchService {

	
	@Autowired
	PersonChurchRepository personChurchRepository;

	public List<PersonChurchPayload> getAlPersonChurches() {

		List<PersonChurchPayload> personChurchPayload = new ArrayList<>();

		for (PersonChurch personChurch : personChurchRepository.findAll()) {

			PersonChurchPayload payload = new PersonChurchPayload();
			
			payload.setId(personChurch.getId());
			payload.setChurch(personChurch.getChurch());
			payload.setPerson(personChurch.getPerson());
			
			
			personChurchPayload.add(payload);
		}

		return personChurchPayload;
	}

//	// create
//	
//	public ResponseEntity<?> createPersonChurch(PersonChurchRequest request) {
//
//		if (request.getChurch() != null) {
//
//			Optional<PersonChurch> existingPersonChurch = request.getId() != null
//					? personChurchRepository.findById(request.getId())
//					: Optional.empty();
//
//			if (!existingPersonChurch.isPresent() && existingPersonChurch.existsByName(request.getName())) {
//				return new ResponseEntity<>(new ApiResponse(false, "churchHierrachy Exists"), HttpStatus.BAD_REQUEST);
//			}
//
//			ChurchHierrachy churchHierrachy = existingchurchHierrachy.isPresent() ? existingchurchHierrachy.get()
//					: new ChurchHierrachy();
//			
//			churchHierrachy.setName(request.getName());
//			
//
//			ChurchHierrachy result = churchHierrachyRepository.save(churchHierrachy);
//
//			if (result != null) {
//				return new ResponseEntity<>(new ApiResponse(true, "churchHierrachy Created"), HttpStatus.OK);
//			}
//
//		}
//
//		return new ResponseEntity<>(new ApiResponse(false, "churchHierrachy Not Created"), HttpStatus.BAD_REQUEST);
//
//	}

//	
	// delete

	public ResponseEntity<?> deletePersonChurch(PersonChurchRequest request) {

		if (request.getId() != null) {

			try {
				personChurchRepository.deleteById(request.getId());

				return new ResponseEntity<>(new ApiResponse(true, "person Church Deleted"), HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		return new ResponseEntity<>(new ApiResponse(false, "person Church Not Deleted"), HttpStatus.BAD_REQUEST);

	}

	
}
