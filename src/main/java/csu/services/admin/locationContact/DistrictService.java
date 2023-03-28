package csu.services.admin.locationContact;

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

import csu.model.admin.locationContact.District;
import csu.repository.locationContact.DistrictRepository;


@Service
public class DistrictService {
	
	@Autowired
    private DistrictRepository districtRepository;

    // GET method to retrieve all countries
    @GetMapping("/")
    public ResponseEntity<List<District>> getAllCountries() {
        List<District> districts = districtRepository.findAll();
        return new ResponseEntity<>(districts, HttpStatus.OK);
    }

    // GET method to retrieve a country by its id
    @GetMapping("/{id}")
    public ResponseEntity<District> getDistrictById(@PathVariable Long id) {
    	District district = districtRepository.findById(id).orElse(null);
        if (district == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(district, HttpStatus.OK);
    }

    // POST method to create a new country
    @PostMapping("/")
    public ResponseEntity<District> createDistrict(@RequestBody District district) {
    	District savedDistrict = districtRepository.save(district);
        return new ResponseEntity<>(savedDistrict, HttpStatus.CREATED);
    }


    // PUT method to update an existing country
    @PutMapping("/{id}")
    public ResponseEntity<District> updateDistrict(@PathVariable Long id, @RequestBody District district) {
    	District existingDistrict = districtRepository.findById(id).orElse(null);
        if (existingDistrict == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingDistrict.setName(district.getName());
        District updated = districtRepository.save(existingDistrict);
        return new ResponseEntity<>(district, HttpStatus.OK);
    }

    // DELETE method to delete a country by its id
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDistrict(@PathVariable Long id) {
    	District district = districtRepository.findById(id).orElse(null);
        if (district == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        districtRepository.delete(district);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
