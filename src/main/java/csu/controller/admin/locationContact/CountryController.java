package csu.controller.admin.LocationContact;

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

import csu.model.admin.LocationContact.Country;
import csu.repository.LocationContact.CountryRepository;

public class CountryController {
	 @Autowired
	    private CountryRepository countryRepository;

	    // GET method to retrieve all countries
	    @GetMapping("/")
	    public ResponseEntity<List<Country>> getAllCountries() {
	        List<Country> countries = countryRepository.findAll();
	        return new ResponseEntity<>(countries, HttpStatus.OK);
	    }
}
