package csu.controller.admin.locationContact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csu.payload.admin.locationContact.RegionPayload;
import csu.services.admin.locationContact.RegionService;

@RestController
@RequestMapping("/api/admin/")
public class RegionController {

	@Autowired 
	private RegionService regionService;
	//get all regions
	
	   @GetMapping("/Regions")
	    public List<RegionPayload> getAllRegions() {

	        // Call the get regions method in the RegionService
	        List<RegionPayload> regions = regionService.getAllRegions();

	        // Return the list of regions
	        return regions;
	    }
	
	//create a region
	//delete a region
	// get region by id
}
