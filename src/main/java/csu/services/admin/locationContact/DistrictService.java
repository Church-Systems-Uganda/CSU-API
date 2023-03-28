package csu.services.admin.locationContact;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csu.model.admin.locationContact.District;
import csu.payload.admin.locationContact.DistrictPayload;
import csu.repository.locationContact.DistrictRepository;

@Service
public class DistrictService {
	
	//repository
			@Autowired
			private DistrictRepository districtRepository;

			//get all parishes
			public List<DistrictPayload> getAllDistricts() {

				List<DistrictPayload> districts = new ArrayList<>();

				for (District district : districtRepository.findAll()) {

					DistrictPayload payload = new DistrictPayload();
					payload.setId(district.getId());
					payload.setName(district.getName());
					
					districts.add(payload);

				}
				return districts;
			}

}
