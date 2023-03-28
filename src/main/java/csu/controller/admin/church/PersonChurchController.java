package csu.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csu.payload.admin.PersonChurch.PersonChurchPayload;
import csu.payload.admin.PersonChurch.PersonChurchRequest;
import csu.services.admin.church.PersonChurchService;

@RestController
@RequestMapping("/api/admin/personchurch")
public class PersonChurchController {

	@Autowired
	private PersonChurchService personChurchService;

	@GetMapping
	public List<PersonChurchPayload> getAllPersonChurches() {
		return personChurchService.getAlPersonChurches();
	}

	@PostMapping
	public ResponseEntity<?> createPersonChurch(@RequestBody PersonChurchRequest request) {
		return personChurchService.createPersonChurch(request);
	}

	@DeleteMapping
	public ResponseEntity<?> deletePersonChurch(@RequestBody PersonChurchRequest request) {
		return personChurchService.deletePersonChurch(request);
	}

}
