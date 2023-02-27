package csu.repository.financeProject;


import org.springframework.data.jpa.repository.JpaRepository;

import csu.model.finaceProjects.Project;

public interface ProjectRepository extends JpaRepository<Project,Long>{

    
}
