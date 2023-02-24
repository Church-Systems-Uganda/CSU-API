package csu.payload.membership.ministy;

import csu.model.admin.AffiliationChurch;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class MinistryPayload {

	
	private Long id;
    private String name;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "church_id", nullable = true)
    private AffiliationChurch church;

	public MinistryPayload() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AffiliationChurch getChurch() {
		return church;
	}

	public void setChurch(AffiliationChurch church) {
		this.church = church;
	}
    
    
}
