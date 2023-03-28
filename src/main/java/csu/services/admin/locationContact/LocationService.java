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

import csu.repository.locationContact.LocationRepository;
import csu.model.admin.locationContact.Location;
import csu.payload.admin.locationContact.LocationPayload;
import csu.payload.admin.locationContact.ParishPayload;


@Service
public class LocationService {
	@Autowired 
	private LocationRepository locationRepository;
	
	
	   @GetMapping("/locations")
	    public List<Location> getAllLocations() {
	        List<Location> locations = locationRepository.findAll();
	        return locations;
	    }
	   
	  
	   @PostMapping("/create-location")
	    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
	        Location savedlocation = locationRepository.save(location);
	        return new ResponseEntity<>(HttpStatus.CREATED);
	    }
	    
	 
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
	    public ResponseEntity<Location> getLocationById(@PathVariable Long id) {
	    	Location location = locationRepository.findById(id).orElse(null);
	        if (location == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(location, HttpStatus.OK);
	    }
}
