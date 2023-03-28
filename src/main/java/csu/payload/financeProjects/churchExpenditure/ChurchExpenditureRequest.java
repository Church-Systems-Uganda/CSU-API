package csu.payload.financeProjects.churchExpenditure;

import csu.model.admin.AffiliationChurch;
import csu.model.finaceProjects.Project;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ChurchExpenditureRequest {
    
	private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id", nullable = true)
	private Project project;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "church_id", nullable = true)
	private AffiliationChurch church;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Project getProject() {
        return project;
    }


    public void setProject(Project project) {
        this.project = project;
    }


    public AffiliationChurch getChurch() {
        return church;
    }


    public void setChurch(AffiliationChurch church) {
        this.church = church;
    }


    public ChurchExpenditureRequest(Long id, Project project, AffiliationChurch church) {
        this.id = id;
        this.project = project;
        this.church = church;
    }
    
    
    
}
