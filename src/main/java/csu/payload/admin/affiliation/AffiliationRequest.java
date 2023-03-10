package csu.payload.admin.affiliation;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import csu.model.admin.AffiliationHierrachy;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AffiliationRequest {
	
	private Long id;
	@NotBlank
	@Size(max = 100)
	private String name;

	@Size(max = 50)
	private String shortName;

	// mean one affiliation can have many hierrachies

	@JsonIgnore
	@OneToMany(mappedBy = "affiliation", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<AffiliationHierrachy> affiliationHierrachy;

	
	
	public AffiliationRequest(@NotBlank @Size(max = 100) String name, @Size(max = 50) String shortName,
			Set<AffiliationHierrachy> affiliationHierrachy) {
		super();
		this.name = name;
		this.shortName = shortName;
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

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Set<AffiliationHierrachy> getAffiliationHierrachy() {
		return affiliationHierrachy;
	}

	public void setAffiliationHierrachy(Set<AffiliationHierrachy> affiliationHierrachy) {
		this.affiliationHierrachy = affiliationHierrachy;
	}


	

}
