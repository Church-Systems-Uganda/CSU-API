package csu.controller.admin.church;

import csu.payload.admin.churchHierrachy.ChurcHierrachyPayload;
import csu.payload.admin.churchHierrachy.ChurchHierrachyRequest;
import csu.payload.general.ApiResponse;
import csu.services.admin.church.ChurchHierrachyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/")
public class ChurchHierrachyController {

    @Autowired
    ChurchHierrachyService churchHierrachyService;

    @GetMapping("/get-churchhierrachy")
    public List<ChurcHierrachyPayload> getAllChurchHierrachies() {
        return churchHierrachyService.getAllChurchHierrachies();
    }

    @PostMapping("/create_churchHierracchy")
    public ResponseEntity<?> createChurchHierrachy(@RequestBody ChurchHierrachyRequest request) {
        return churchHierrachyService.createChurcHierrachy(request);
    }

    @DeleteMapping("/delete_hierrachy")
    public ResponseEntity<?> deleteChurchHierrachy(@RequestBody ChurchHierrachyRequest request) {
        return churchHierrachyService.deleteChurchHierrachy(request);
    }

}
