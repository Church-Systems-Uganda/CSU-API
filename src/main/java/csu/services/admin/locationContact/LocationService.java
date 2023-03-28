package src.main.java.csu.services.admin.locationContact;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {
	//repository
			@Autowired
			private LocationRepository locationRepository;

			//get all parishes
			public List<LocationPayload> getAlllocations() {

				List<LocationPayload> locations = new ArrayList<>();

				for (Location location : locationRepository.findAll()) {

					LocationPayload payload = new LocationPayload();
					payload.setId(location.getId());
					payload.setName(location.getName());
					
					location.add(payload);

				}
				return location;
			}
}
