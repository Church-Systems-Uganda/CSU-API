package csu.services.admin.locationContact;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csu.model.admin.locationContact.Parish;
import csu.payload.admin.locationContact.ParishPayload;
import csu.repository.locationContact.ParishRepository;
import src.main.java.csu.controller.admin.locationContact.DeleteMapping;
import src.main.java.csu.controller.admin.locationContact.GetMapping;
import src.main.java.csu.controller.admin.locationContact.HttpStatus;
import src.main.java.csu.controller.admin.locationContact.ParishService;
import src.main.java.csu.controller.admin.locationContact.PathVariable;
import src.main.java.csu.controller.admin.locationContact.PostMapping;
import src.main.java.csu.controller.admin.locationContact.RequestBody;
import src.main.java.csu.controller.admin.locationContact.RequestMapping;
import src.main.java.csu.controller.admin.locationContact.ResponseEntity;
import src.main.java.csu.controller.admin.locationContact.parish;

@Service
@RequestMapping("/api/admin/")
public class ParishService {
	
	@Autowired 
	private ParishService parishesService;
	//get all Parishes
	
	   @GetMapping("/Parishes")
	    public List<ParishPayload> getAllParishes() {
	        // Call the getAllAffiliations method in the AffiliationService
	        List<ParishPayload> parishes = parishesService.getAllParishes();
	        // Return the list of affiliations
	        return parishes;
	    }
	   
	 //create a region
	   @PostMapping("/")
	    public ResponseEntity<parish> createParish(@RequestBody Parish parish) {
	        Parish savedparish = parishRepository.save(parish);
	        return new ResponseEntity<>(savedParish, HttpStatus.CREATED);
	    }
	    
	//delete a region
	    @DeleteMapping("/{id}")
	    public ResponseEntity<HttpStatus> deleteParish(@PathVariable Long id) {
	        Parish parish = parishRepository.findById(id).orElse(null);
	        if (parish == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        parishRepository.delete(parish);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	// get region by id
	    @GetMapping("/{id}")
	    public ResponseEntity<parish> getParishById(@PathVariable Long id) {
	    	Parish parish = parishRepository.findById(id).orElse(null);
	        if (parish == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(parish, HttpStatus.OK);
	    }

}
