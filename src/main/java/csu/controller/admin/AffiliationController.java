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
@RequestMapping("/api/admin/affiliations")
public class AffiliationController {

    // Autowire the AffiliationService
    @Autowired
    private AffiliationService affiliationService;

    /**
     * Get a list of all affiliations
     * @return List of AffiliationPayload objects
     */
    @GetMapping
    public List<AffiliationPayload> getAllAffiliations() {
        // Call the getAllAffiliations method in the AffiliationService
        List<AffiliationPayload> affiliations = affiliationService.getAllAffiliations();
        // Return the list of affiliations
        return affiliations;
    }

//    @PostMapping("/create-affiliation")
//    public ResponseEntity<?> createAffiliation(@Valid @RequestBody AffiliationRequest request) {
//        // Call the createAffiliation method in the AffiliationService
//        ResponseEntity<?> response = affiliationService.createAffiliation(request);
//        // Return the response from the service
//        return response;
//    }

    /**
     * Delete an affiliation based on the request payload
     * @param request The AffiliationRequest payload in the request body
     * @return ResponseEntity with message and HTTP status code
     */
    @PostMapping("/delete-affiliation")
    public ResponseEntity<?> deleteAffiliation(@RequestBody AffiliationRequest request) {
        // Call the deleteAffiliation method in the AffiliationService
        ResponseEntity<?> response = affiliationService.deleteAffiliation(request);
        // Return the response from the service
        return response;
    }

}
