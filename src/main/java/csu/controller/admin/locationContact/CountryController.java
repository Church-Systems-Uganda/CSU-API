package src.main.java.csu.controller.admin.locationContact;


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
import csu.repository.locationContact.CountryRepository;
import src.main.java.csu.controller.admin.AffiliationPayload;
import src.main.java.csu.controller.admin.AffiliationRequest;
import src.main.java.csu.controller.admin.AffiliationService;
import src.main.java.csu.controller.admin.Valid;

public class CountryController {
	 @Autowired
	    private CountryService countryService;

	    /**
	     * Get a list of all affiliations
	     * @return List of AffiliationPayload objects
	     */
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
	        // Call the deleteAffiliation method in the AffiliationService
	        ResponseEntity<?> response = countryService.deleteCountry(request);
	        // Return the response from the service
	        return response;
	    }

	  //get affiliation by id
	  	@GetMapping("/country/{id}")
	      public ResponseEntity<?> getCountryById(@org.springframework.web.bind.annotation.PathVariable("id") Long id) {
	          ResponseEntity<?> country = countryService.getCountryById(id);

	          return new ResponseEntity<>(country, HttpStatus.OK);
	      }
}
