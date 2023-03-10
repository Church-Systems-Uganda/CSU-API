package csu.payload.admin.affiliation;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import csu.model.admin.AffiliationHierrachy;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

public class AffiliationPayload {

	private Long id;
	
	@Size(max = 100)
	private String name;

	@Size(max = 50)
	private String shortName;

	public AffiliationPayload() {
		super();
	}

	
	
	@JsonIgnore
	@OneToMany(mappedBy = "affliation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)	private Set<AffiliationHierrachy> affiliationHierrachies;

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
	

}
