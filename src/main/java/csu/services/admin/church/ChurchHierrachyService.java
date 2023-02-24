package csu.services.admin.church;

import java.util.ArrayList;
import java.util.List;

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
