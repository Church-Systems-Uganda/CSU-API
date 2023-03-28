package src.main.java.csu.services.admin.locationContact;

import java.util.ArrayList;
import java.util.List;

import src.main.java.csu.controller.admin.locationContact.Autowired;
import src.main.java.csu.controller.admin.locationContact.DeleteMapping;
import src.main.java.csu.controller.admin.locationContact.District;
import src.main.java.csu.controller.admin.locationContact.DistrictRepository;
import src.main.java.csu.controller.admin.locationContact.GetMapping;
import src.main.java.csu.controller.admin.locationContact.HttpStatus;
import src.main.java.csu.controller.admin.locationContact.PathVariable;
import src.main.java.csu.controller.admin.locationContact.PostMapping;
import src.main.java.csu.controller.admin.locationContact.PutMapping;
import src.main.java.csu.controller.admin.locationContact.RequestBody;
import src.main.java.csu.controller.admin.locationContact.ResponseEntity;

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
