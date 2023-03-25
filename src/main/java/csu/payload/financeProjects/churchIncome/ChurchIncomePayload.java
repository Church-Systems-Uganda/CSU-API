package csu.payload.financeProjects.churchIncome;

import csu.model.admin.AffiliationChurch;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ChurchIncomePayload {
	
	private Long id;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "church_id", nullable = true)
	private AffiliationChurch church;


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


	public ChurchIncomePayload() {
		
	}

	
	
	
}
