package csu.services.admin.church;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csu.repository.admin.Church.ChurchHierrachyRepository;

@Service
public class ChurchHierrachyService {
    
    @Autowired
    ChurchHierrachyRepository churchHierrachyRepository;

//
//    /*
//	 * Getting all affiliations
//	 */
//	public List<ChurchHierrachyPayload> getAllChurchHierrachy() {
//
//		List<ChurchHierrachyPayload> churchHierrachyPayload = new ArrayList<>();
//
//		for (ChurchHierrachy churchHierrachy : churchHierrachyRepositoryy.findAll()) {
//
//			ChurchHierrachyPayload payload = new ChurchHierrachyPayload();
//
//			payload.setId(churchHierrachy.getId());
//			payload.setTier(churchHierrachy.getTier());
//			payload.setPosition(churchHierrachy.getPosition());
//			churchHierrachyPayload.add(payload);
//
//		}
//		return churchHierrachyPayload;
//	}

    


}
