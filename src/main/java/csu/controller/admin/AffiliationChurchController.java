package csu.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csu.payload.admin.affiliationChurch.AffiliationChurchRequest;
import csu.services.admin.AffiliationChurchService;

@RestController
@RequestMapping("/api/admin/affiliation-churches")
public class AffiliationChurchController {

    // Autowire the AffiliationChurchService
    @Autowired
    private AffiliationChurchService affiliationChurchService;

    /**
     * Delete an affiliation church based on the request payload
     * @param request The AffiliationChurchRequest payload in the request body
     * @return ResponseEntity with message and HTTP status code
     */
    @DeleteMapping
    public ResponseEntity<?> deleteAffiliationChurch(@RequestBody AffiliationChurchRequest request) {
        // Call the deleteAffiliationChurch method in the AffiliationChurchService
        ResponseEntity<?> response = affiliationChurchService.deleteAffiliationChurch(request);
        // Return the response from the service
        return response;
    }
}
