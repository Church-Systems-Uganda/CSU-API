package csu.services.membership;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csu.model.membership.Ministry;
import csu.payload.membership.ministy.MinistryPayload;
import csu.repository.membership.MinistryRepository;

@Service
public class MinistryService {

	@Autowired
	MinistryRepository ministryRepository;
	
	public List<MinistryPayload>  getAllMinistries(){
		List<MinistryPayload> ministries = new ArrayList<>();
		
		for(Ministry ministry :ministryRepository.findAll() ) {
			
			MinistryPayload ministryPayload = new MinistryPayload();
			
			ministryPayload.setId(ministry.getId());
			ministryPayload.setName(ministry.getName());
			ministryPayload.setChurch(ministry.getChurch());
			
			ministries.add(ministryPayload);
		}
		
		return ministries;
		
		
	}
	
}
