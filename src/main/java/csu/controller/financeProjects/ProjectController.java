package csu.controller.financeProjects;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import csu.payload.financeProjects.projects.ProjectsPayload;
import csu.services.financeProjects.ProjectService;

@Controller
@RequestMapping("/api/FinanceProjects")

public class ProjectController {
    
@Autowired
ProjectService projectService;

//logic

//get all projets

@GetMapping("/projets")
	public List<ProjectsPayload> getAllProjects(){
		return projectService.getAllProjects();
	}


//create and edit projects

//delete project

}
