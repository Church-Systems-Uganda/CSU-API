package csu.services.admin.locationContact;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csu.model.admin.locationContact.Parish;
import csu.payload.admin.locationContact.ParishPayload;
import csu.repository.locationContact.ParishRepository;

@Service
public class ParishService {
	
	//repository
		@Autowired
		private ParishRepository parishRepository;

		//get all parishes
		public List<ParishPayload> getAllParishes() {

			List<ParishPayload> parishes = new ArrayList<>();

			for (Parish parish : parishRepository.findAll()) {

				ParishPayload parishpayload = new ParishPayload();
				parishpayload.setId(parish.getId());
				parishpayload.setName(parish.getName());
				
				parishes.add(parishpayload);

			}
			return parishes;
		}

}
