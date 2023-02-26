package csu.payload.admin.affiliationChurch;

import csu.model.admin.AffiliationHierrachy;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AffiliationChurchRequest {

	private Long id;

	@NotBlank
	@Size(max = 100)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "affiliation_hierrachy_id", nullable = false)
	private AffiliationHierrachy affiliationHierrachy;

	public AffiliationChurchRequest(@NotBlank @Size(max = 100) String name, AffiliationHierrachy affiliationHierrachy) {
		super();
		this.name = name;
		this.affiliationHierrachy = affiliationHierrachy;
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

	public AffiliationHierrachy getAffiliationHierrachy() {
		return affiliationHierrachy;
	}

	public void setAffiliationHierrachy(AffiliationHierrachy affiliationHierrachy) {
		this.affiliationHierrachy = affiliationHierrachy;
	}
	
}
