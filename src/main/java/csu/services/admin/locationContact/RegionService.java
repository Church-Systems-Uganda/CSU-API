package csu.services.admin.locationContact;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csu.model.admin.Affiliation;
import csu.model.admin.locationContact.Region;
import csu.payload.admin.locationContact.RegionPayload;
import csu.repository.locationContact.RegionRepository;

@Service
public class RegionService {
	
	//repository
	@Autowired
	private RegionRepository regionRepository;

	//get all regions
	public List<RegionPayload> getAllRegions() {

		List<RegionPayload> regions = new ArrayList<>();

		for (Region region : regionRepository.findAll()) {

			RegionPayload payload = new RegionPayload();
			payload.setId(region.getId());
			payload.setName(region.getName());
			
			regions.add(payload);

		}
		return regions;
	}
	
		//create a region
		//delete a region
		// get region by id
}
