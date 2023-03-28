package csu.controller.admin.locationContact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csu.payload.admin.locationContact.ParishPayload;
import csu.services.admin.locationContact.ParishService;

@RestController

@RequestMapping("/api/v1/parishes")
public class ParishController {

    @Autowired
    private ParishService parishservice;

    @GetMapping
    public List<ParishPayload> getAllParishes() {
    	return parishservice.getAllParishes();
    }

}
