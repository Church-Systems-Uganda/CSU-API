package src.main.java.csu.services.admin.locationContact;

import java.util.ArrayList;
import java.util.List;

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
					
					district.add(payload);

				}
				return district;
			}

}
