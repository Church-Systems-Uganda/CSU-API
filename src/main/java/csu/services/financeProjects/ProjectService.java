package csu.services.financeProjects;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csu.model.finaceProjects.Project;
import csu.payload.financeProjects.projects.ProjectsPayload;
import csu.repository.financeProject.ProjectRepository;

@Service
public class ProjectService {

@Autowired

ProjectRepository projectRepository;
//get all projets

public List<ProjectsPayload>  getAllProjects(){


    List<ProjectsPayload> projects = new ArrayList<>();
    
    for ( Project project :projectRepository.findAll()) {
        
        ProjectsPayload projectsPayload = new ProjectsPayload();

        projectsPayload.setChurch(project.getChurch());
        projectsPayload.setId(project.getId());

        projects.add((projectsPayload));
        
    }
    return projects;
    }

    
}
