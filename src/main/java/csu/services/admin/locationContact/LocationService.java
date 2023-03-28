package src.main.java.csu.services.admin.locationContact;

import java.util.ArrayList;
import java.util.List;

import src.main.java.csu.controller.admin.locationContact.Autowired;
import src.main.java.csu.controller.admin.locationContact.DeleteMapping;
import src.main.java.csu.controller.admin.locationContact.GetMapping;
import src.main.java.csu.controller.admin.locationContact.HttpStatus;
import src.main.java.csu.controller.admin.locationContact.LoactionsPayload;
import src.main.java.csu.controller.admin.locationContact.Location;
import src.main.java.csu.controller.admin.locationContact.LocationService;
import src.main.java.csu.controller.admin.locationContact.ParishesPayload;
import src.main.java.csu.controller.admin.locationContact.PathVariable;
import src.main.java.csu.controller.admin.locationContact.PostMapping;
import src.main.java.csu.controller.admin.locationContact.RequestBody;
import src.main.java.csu.controller.admin.locationContact.ResponseEntity;
import src.main.java.csu.controller.admin.locationContact.location;

@Service
public class LocationService {
	@Autowired 
	private LocationService locationService;
	//get all Parishes
	
	   @GetMapping("/locations")
	    public List<LoactionsPayload> getAllLocations() {
	        // Call the getAllAffiliations method in the AffiliationService
	        List<ParishesPayload> locations = locationsService.getAllParishes();
	        // Return the list of affiliations
	        return locations;
	    }
	   
	   //create a region
	   @PostMapping("/")
	    public ResponseEntity<location> createLocation(@RequestBody Location location) {
	        Location savedlocation = locationRepository.save(location);
	        return new ResponseEntity<>(savedLocation, HttpStatus.CREATED);
	    }
	    
	  //delete a region
	    @DeleteMapping("/{id}")
	    public ResponseEntity<HttpStatus> deleteLocation(@PathVariable Long id) {
	    	Location location = locationRepository.findById(id).orElse(null);
	        if (location == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        locationRepository.delete(location);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	 // get region by id
	    @GetMapping("/{id}")
	    public ResponseEntity<location> getLocationById(@PathVariable Long id) {
	    	Location location = locationRepository.findById(id).orElse(null);
	        if (location == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(location, HttpStatus.OK);
	    }
}