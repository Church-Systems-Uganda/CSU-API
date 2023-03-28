package csu.controller.admin.locationContact;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csu.model.admin.locationContact.Parish;
import csu.payload.admin.locationContact.ParishPayload;
import csu.services.admin.locationContact.ParishService;

@RestController
@RequestMapping("/api/admin/")
public class ParishController {
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
