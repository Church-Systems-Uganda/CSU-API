package csu.services.admin.church;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import csu.model.admin.Church.ChurchHierrachy;
import csu.payload.admin.churchHierrachy.ChurcHierrachyPayload;
import csu.payload.admin.churchHierrachy.ChurchHierrachyRequest;

import csu.payload.general.ApiResponse;
import csu.repository.admin.Church.ChurchHierrachyRepository;

@Service
public class ChurchHierrachyService {

	@Autowired
	ChurchHierrachyRepository churchHierrachyRepository;

	public List<ChurcHierrachyPayload> getAllChurchHierrachies() {

		List<ChurcHierrachyPayload> churcHierrachyPayload = new ArrayList<>();

		for (ChurchHierrachy churchHierrachy : churchHierrachyRepository.findAll()) {

			ChurcHierrachyPayload payload = new ChurcHierrachyPayload();
			payload.setId(churchHierrachy.getId());
			payload.setTier(churchHierrachy.getTier());
			// payload.setPosition(churchHierrachy.getPosition());
			churcHierrachyPayload.add(payload);
		}

		return churcHierrachyPayload;
	}

	// create
	
	public ResponseEntity<?> createChurcHierrachy(ChurchHierrachyRequest request) {

		if (request.getName() != null) {

			Optional<ChurchHierrachy> existingchurchHierrachy = request.getId() != null
					? churchHierrachyRepository.findById(request.getId())
					: Optional.empty();

			if (!existingchurchHierrachy.isPresent() && churchHierrachyRepository.existsByName(request.getName())) {
				return new ResponseEntity<>(new ApiResponse(false, "churchHierrachy Exists"), HttpStatus.BAD_REQUEST);
			}

			ChurchHierrachy churchHierrachy = existingchurchHierrachy.isPresent() ? existingchurchHierrachy.get()
					: new ChurchHierrachy();
			
			churchHierrachy.setName(request.getName());
			

			ChurchHierrachy result = churchHierrachyRepository.save(churchHierrachy);

			if (result != null) {
				return new ResponseEntity<>(new ApiResponse(true, "churchHierrachy Created"), HttpStatus.OK);
			}

		}

		return new ResponseEntity<>(new ApiResponse(false, "churchHierrachy Not Created"), HttpStatus.BAD_REQUEST);

	}

	
	// delete

	public ResponseEntity<?> deleteChurchHierrachy(ChurchHierrachyRequest request) {

		if (request.getId() != null) {

			try {
				churchHierrachyRepository.deleteById(request.getId());

				return new ResponseEntity<>(new ApiResponse(true, "ChurchHierrachy Deleted"), HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		return new ResponseEntity<>(new ApiResponse(false, "ChurchHierrachy Not Deleted"), HttpStatus.BAD_REQUEST);

	}

}
