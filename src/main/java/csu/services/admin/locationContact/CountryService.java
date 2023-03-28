package csu.services.admin.locationContact;

import java.util.List;

import org.springframework.stereotype.Service;

import src.main.java.csu.controller.admin.locationContact.Autowired;
import src.main.java.csu.controller.admin.locationContact.Country;
import src.main.java.csu.controller.admin.locationContact.CountryRepository;
import src.main.java.csu.controller.admin.locationContact.DeleteMapping;
import src.main.java.csu.controller.admin.locationContact.GetMapping;
import src.main.java.csu.controller.admin.locationContact.HttpStatus;
import src.main.java.csu.controller.admin.locationContact.PathVariable;
import src.main.java.csu.controller.admin.locationContact.PostMapping;
import src.main.java.csu.controller.admin.locationContact.PutMapping;
import src.main.java.csu.controller.admin.locationContact.RequestBody;
import src.main.java.csu.controller.admin.locationContact.ResponseEntity;

@Service
public class CountryService {
	 @Autowired
	    private CountryRepository countryRepository;
	    // GET method to retrieve all countries
	    @GetMapping("/")
	    public ResponseEntity<List<Country>> getAllCountries() {
	        List<Country> countries = countryRepository.findAll();
	        return new ResponseEntity<>(countries, HttpStatus.OK);
	    }
	    
	    // GET method to retrieve a country by its id
	    @GetMapping("/{id}")
	    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
	        Country country = countryRepository.findById(id).orElse(null);
	        if (country == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(country, HttpStatus.OK);
	    }
	    
	 // POST method to create a new country
	    @PostMapping("/")
	    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
	        Country savedCountry = countryRepository.save(country);
	        return new ResponseEntity<>(savedCountry, HttpStatus.CREATED);
	    }
	    
	    // PUT method to update an existing country
	    @PutMapping("/{id}")
	    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country country) {
	        Country existingCountry = countryRepository.findById(id).orElse(null);
	        if (existingCountry == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        existingCountry.setName(country.getName());
	        Country updated = countryRepository.save(existingCountry);
	        return new ResponseEntity<>(country, HttpStatus.OK);
	    }
	    
	 // DELETE method to delete a country by its id
	    @DeleteMapping("/{id}")
	    public ResponseEntity<HttpStatus> deleteCountry(@PathVariable Long id) {
	        Country country = countryRepository.findById(id).orElse(null);
	        if (country == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        countryRepository.delete(country);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    
	
	
}
