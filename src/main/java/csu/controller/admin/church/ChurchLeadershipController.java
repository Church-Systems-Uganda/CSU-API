package csu.controller.admin.church;


import csu.payload.general.ApiResponse;
import csu.services.admin.church.ChurchLeadershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/")
public class ChurchLeadershipController {

    @Autowired
    ChurchLeadershipService churchLeadershipService;

    @GetMapping("/church_leadership")
    public List<ChurchLeadershipPayload> getAllChurchLeaderships() {
        return churchLeadershipService.getAllChurchLeaderships();
    }

    @PostMapping("/create_church_leadership")
    public ResponseEntity<?> createChurchLeadership(@RequestBody ChurchLeadershipRequest request) {
        return churchLeadershipService.createChurchLeadership(request);
    }

    @DeleteMapping("/church_leadership")
    public ResponseEntity<?> deleteChurchLeadership(@RequestBody ChurchLeadershipRequest request) {
        return churchLeadershipService.deleteChurchLeadership(request);
    }

}
