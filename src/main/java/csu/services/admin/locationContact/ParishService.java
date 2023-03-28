package csu.services.admin.locationContact;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import csu.model.admin.locationContact.Parish;
import csu.payload.admin.locationContact.ParishPayload;
import csu.repository.locationContact.ParishRepository;

@Service
@RequestMapping("/api/admin/")
public class ParishService {
	
	@Autowired 
	private ParishRepository parishRepository;
	//get all Parishes
	
	   @GetMapping("/Parishes")
	    public List<Parish> getAllParishes() {
	        // Call the getAllAffiliations method in the AffiliationService
	        List<Parish> parishes = parishRepository.findAll();
	        // Return the list of affiliations
	        return parishes;
	    }
	   
	 //create a region
	   @PostMapping("/create-parish")
	    public ResponseEntity<Parish> createParish(@RequestBody Parish parish) {
	        Parish savedparish = parishRepository.save(parish);
	        return new ResponseEntity<>(HttpStatus.CREATED);
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
