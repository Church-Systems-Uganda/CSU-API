package csu.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csu.payload.admin.affiliationHierrachy.AffiliationHierrachyPayload;
import csu.payload.admin.affiliationHierrachy.AffiliationHierrachyRequest;
import csu.payload.general.ApiResponse;
import csu.services.admin.AffiliationHierrachyService;

/**
 * Controller for managing affiliation hierarchies.
 */
@RestController
@RequestMapping("/api/admin")
public class AffiliationHierrachyController {

	@Autowired
	AffiliationHierrachyService affiliationHierarchyService;

	/**
	 * Get a list of all affiliation hierarchies.
	 *
	 * @return the list of all affiliation hierarchies
	 */
	@GetMapping("/affiliation-hierarchy")
	public List<AffiliationHierrachyPayload> getAllAffiliationHierarchy() {
		return affiliationHierarchyService.getAllAffiliationHierrachy();
	}

	
	  @PostMapping("/create-AffiliationHierarchy")
	    public ResponseEntity<?> createAffiliationHierarchy(@RequestBody AffiliationHierrachyRequest request) {
	        try {
	            affiliationHierarchyService.createAffiliationHierrachy(request);
	            return affiliationHierarchyService.createAffiliationHierrachy(request);
	        } catch (IllegalArgumentException e) {
	            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
	        }
	    }
	  
	/**
	 * Delete an affiliation hierarchy.
	 *
	 * @param request the request containing the ID of the affiliation hierarchy to delete
	 * @return the response entity indicating the result of the deletion operation
	 */
	@PostMapping("/delete-affiliation-hierarchy")
	public ResponseEntity<?> deleteAffiliationHierarchy(@RequestBody AffiliationHierrachyRequest request) {
		return affiliationHierarchyService.deleteAffiliationHierrachy(request);
	}
}
