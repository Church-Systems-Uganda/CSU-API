package csu.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csu.payload.admin.affiliation.AffiliationPayload;
import csu.payload.admin.affiliation.AffiliationRequest;
import csu.services.admin.AffiliationService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin")
public class AffiliationController {

    // Autowire the AffiliationService
    @Autowired
    private AffiliationService affiliationService;

    /**
     * Get a list of all affiliations
     * @return List of AffiliationPayload objects
     */
    @GetMapping("/affiliations")
    public List<AffiliationPayload> getAllAffiliations() {
        // Call the getAllAffiliations method in the AffiliationService
        List<AffiliationPayload> affiliations = affiliationService.getAllAffiliations();
        // Return the list of affiliations
        return affiliations;
    }

    @PostMapping("/create-affiliation")
    public ResponseEntity<?> createAffiliation(@Valid @RequestBody AffiliationRequest request) {
        // Call the createAffiliation method in the AffiliationService
        ResponseEntity<?> response = affiliationService.createAffliation(request);
        // Return the response from the service
        return response;
    }

   
    @PostMapping("/delete-affiliation")
    public ResponseEntity<?> deleteAffiliation(@RequestBody AffiliationRequest request) {
        // Call the deleteAffiliation method in the AffiliationService
        ResponseEntity<?> response = affiliationService.deleteAffiliation(request);
        // Return the response from the service
        return response;
    }

}
