package csu.payload.financeProjects.projects;

import csu.model.admin.AffiliationChurch;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ProjectRequest {
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "church_id", nullable = true)
    private AffiliationChurch church;

    public ProjectRequest(Long id, AffiliationChurch church) {
        this.id = id;
        this.church = church;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AffiliationChurch getChurch() {
        return church;
    }

    public void setChurch(AffiliationChurch church) {
        this.church = church;
    }

    
}
