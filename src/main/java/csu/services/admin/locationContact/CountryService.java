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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import csu.model.admin.locationContact.Country;
import csu.payload.admin.locationContact.CountryPayload;
import csu.payload.admin.locationContact.CountryRequest;
import csu.repository.locationContact.CountryRepository;
import jakarta.validation.Valid;


@Service
public class CountryService {
	 @Autowired
	 
	    CountryRepository countryRepository;
	    // GET method to retrieve all countries
	    @GetMapping("/getAllCountries")
	    public List<CountryPayload> getAllCountries() {
	    	List<CountryPayload> countries = new ArrayList<>();
	        
	    	for (Country country : countryRepository.findAll()) {
	    		
	    		CountryPayload CountryPayload = new CountryPayload();

				CountryPayload.setId(country.getId());
				//CountryPayload.setChurch(country.getChurch());

				country.add(CountryPayload);
			}
	        return countries;
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
	    public ResponseEntity<Country> createCountry(@RequestBody @Valid CountryRequest request) {
	        Country savedCountry = countryRepository.saveAll(request);
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
