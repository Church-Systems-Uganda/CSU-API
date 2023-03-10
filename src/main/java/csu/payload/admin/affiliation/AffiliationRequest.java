package csu.payload.admin.affiliation;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import csu.model.admin.AffiliationHierrachy;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AffiliationRequest {
	
	private Long id;
	
	@NotNull
	@Size(max = 100)
	private String name;

	@Size(max = 50)
	private String shortName;

	
	
	@JsonIgnore
	@OneToMany(mappedBy = "affliation", fetch = FetchType.LAZY)
	private Set<AffiliationHierrachy> affiliationHierrachies;



	public AffiliationRequest(@NotNull @Size(max = 100) String name, @Size(max = 50) String shortName,
			Set<AffiliationHierrachy> affiliationHierrachies) {
		super();
		this.name = name;
		this.shortName = shortName;
		this.affiliationHierrachies = affiliationHierrachies;
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



	public Set<AffiliationHierrachy> getAffiliationHierrachies() {
		return affiliationHierrachies;
	}



	public void setAffiliationHierrachies(Set<AffiliationHierrachy> affiliationHierrachies) {
		this.affiliationHierrachies = affiliationHierrachies;
	}

	
}
