package csu.controller.admin.locationContact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import csu.services.admin.locationContact.CountryService;
import jakarta.validation.Valid;


public class CountryController {
	 @Autowired
	    CountryService countryService;

	    @GetMapping("/countries")
	    public List<CountryPayload> getAllCountries() {
	        // Call the getAllAffiliations method in the AffiliationService
	        List<CountryPayload> countries = countryService.getAllCountries();
	        // Return the list of affiliations
	        return countries;
	    }

	    @PostMapping("/create-country")
	    public ResponseEntity<?> createCountry(@Valid @RequestBody CountryRequest request) {
	        // Call the createAffiliation method in the AffiliationService
	        ResponseEntity<?> response = countryService.createCountry(request);
	        // Return the response from the service
	        return response;
	    }

	   
	    @PostMapping("/delete-country")
	    public ResponseEntity<?> deleteCountry(@RequestBody CountryRequest request) {
	        return countryService.createCountry(request);
	    }
}
