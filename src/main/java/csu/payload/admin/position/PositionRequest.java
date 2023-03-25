package csu.payload.admin.position;

import java.util.HashSet;
import java.util.Set;

import csu.model.admin.AffiliationHierrachy;
import csu.model.admin.Affiliation;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PositionRequest {

	private Long id;

	@NotBlank
	@Size(max = 100)
	private String name;

	@Size(max = 50)
	private String shortName;

	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "hierarchy_id", nullable=false)
	 private AffiliationHierrachy hierarchy;
	 
	 @ManyToMany(mappedBy = "levelHead")
	 private Set<Affiliation> affiliations = new HashSet<>();

	 
	 
	public PositionRequest(@NotBlank @Size(max = 100) String name, @Size(max = 50) String shortName,
			AffiliationHierrachy hierarchy, Set<Affiliation> affiliations) {
		super();
		this.name = name;
		this.shortName = shortName;
		this.hierarchy = hierarchy;
		this.affiliations = affiliations;
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

	public AffiliationHierrachy getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(AffiliationHierrachy hierarchy) {
		this.hierarchy = hierarchy;
	}

	public Set<Affiliation> getAffiliations() {
		return affiliations;
	}

	public void setAffiliations(Set<Affiliation> affiliations) {
		this.affiliations = affiliations;
	}

	
}
