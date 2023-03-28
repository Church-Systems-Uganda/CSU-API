package src.main.java.csu.controller.admin.locationContact;

import java.util.List;

@RestController
@RequestMapping("/api/admin/")
public class LocationController {
	
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
