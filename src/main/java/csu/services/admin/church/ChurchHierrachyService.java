package csu.services.admin.church;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import csu.payload.admin.churchHierrachy.ChurcHierrachyPayload;
import csu.repository.admin.Church.ChurchHierrachyRepository;

@Service
public class ChurchHierrachyService {
    
    @Autowired
    ChurchHierrachyRepository churchHierrachyRepository;
    
    public List<ChurcHierrachyPayload> getAllChurchHierrachies(){
    	
    	
    List<ChurcHierrachyPayload> churcHierrachyPayload = new ArrayList<>();
    
    for(ChurchHierrachy churchHierrachy : churchHierrachyRepository.findAll()) {
    	
    	ChurcHierrachyPayload payload = new ChurcHierrachyPayload();
    }
    }

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
