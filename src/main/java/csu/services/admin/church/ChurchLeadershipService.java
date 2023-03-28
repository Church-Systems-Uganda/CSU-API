package csu.services.admin.church;

import csu.model.admin.Church.ChurchLeadership;
import csu.payload.admin.ChurchLeadership.ChurchLeadershipPayload;
import csu.payload.admin.ChurchLeadership.ChurchLeadershipRequest;
import csu.repository.admin.Church.ChurchLeadershipRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChurchLeadershipService {

    @Autowired
    ChurchLeadershipRepository churchLeadershipRepository;

    public List<ChurchLeadershipPayload> getAllChurchLeaderships() {
        List<ChurchLeadershipPayload> churchLeadershipPayload = new ArrayList<>();
        // Convert ChurchLeadership objects to ChurchLeadershipPayload objects
        return ChurchLeadershipMapper.mapToPayloads(churchLeaderships);
    }

    public ResponseEntity<?> createChurchLeadership(ChurchLeadershipRequest request) {
        // Validate request
        ChurchLeadershipValidator.validateCreateRequest(request);

        // Convert request to ChurchLeadership object
        ChurchLeadership churchLeadership = ChurchLeadershipMapper.mapToEntity(request);

        // Save ChurchLeadership object to database
        churchLeadershipRepository.save(churchLeadership);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> deleteChurchLeadership(ChurchLeadershipRequest request) {
        // Validate request
        ChurchLeadershipValidator.validateDeleteRequest(request);

        // Find ChurchLeadership object by ID
        ChurchLeadership churchLeadership = churchLeadershipRepository.findById(request.getId())
                .orElseThrow();

        // Delete ChurchLeadership object from database
        churchLeadershipRepository.delete(churchLeadership);

        return ResponseEntity.ok().build();
    }
}
