package csu.controller.admin.locationContact;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csu.services.admin.locationContact.ParishService;

@RestController
@RequestMapping("/api/admin/")
public class ParishController {
	@Autowired 
	private ParishService parishesService;
	//get all Parishes
	
	   @GetMapping("/Parishes")
	    public List<ParishesPayload> getAllParishes() {
	        // Call the getAllAffiliations method in the AffiliationService
	        List<ParishesPayload> parishes = parishesService.getAllParishes();
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
	    public ResponseEntity<Parish> getParishById(@PathVariable Long id) {
	    	Parish parish = parishRepository.findById(id).orElse(null);
	        if (parish == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(parish, HttpStatus.OK);
	    }

}
