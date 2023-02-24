package csu.controller.admin.church;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csu.services.admin.church.ChurchHierrachyService;

@RestController
@RequestMapping("/api/admin")
public class ChurchHierrachyController {

    @Autowired
    ChurchHierrachyService churchHierrachyService;

//    @GetMapping("/ChurchHierrachy")
//	public List<ChurchHierrachyPayload> getAllChurchHierrachy() {
//		return ChurchHierrachyService.getAllChurchHierrachy();
//	}
    
}
