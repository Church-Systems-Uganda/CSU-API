package csu.payload.admin.affiliation;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import csu.model.admin.AffiliationHierrachy;
import csu.model.admin.Position;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AffiliationPayload {

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

	@ManyToMany(mappedBy = "affiliations")
	private Set<Position> position = new HashSet<>();

	public AffiliationPayload() {
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

	public Set<Position> getPosition() {
		return position;
	}

	public void setPosition(Set<Position> position) {
		this.position = position;
	}

	
}
