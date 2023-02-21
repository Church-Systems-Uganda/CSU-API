package csu.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import csu.services.admin.PositionService;

@Controller
@RequestMapping("/api/admin")

public class PositionController {
	
	@Autowired
	PositionService  positionService;

	@GetMapping("/positions")
	public List<PositionPayload> getAllPositions() {
		return positionService.getAllPositions();
	}

}
