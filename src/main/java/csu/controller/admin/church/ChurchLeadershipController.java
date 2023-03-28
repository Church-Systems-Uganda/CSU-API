package csu.controller.admin.church;

import csu.payload.admin.churchLeadership.ChurchLeadershipPayload;
import csu.payload.admin.churchLeadership.ChurchLeadershipRequest;
import csu.payload.general.ApiResponse;
import csu.services.admin.church.ChurchLeadershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;