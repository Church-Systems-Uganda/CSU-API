package csu.services.admin.locationContact;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParishService {
	
	//repository
		@Autowired
		private ParishRepository parishRepository;

		//get all parishes
		public List<ParishPayload> getAllParishes() {

			List<ParishPayload> parishes = new ArrayList<>();

			for (Parish parish : parishRepository.findAll()) {

				ParishPayload payload = new ParishPayload();
				payload.setId(parish.getId());
				payload.setName(parish.getName());
				
				parish.add(payload);

			}
			return parish;
		}

}
