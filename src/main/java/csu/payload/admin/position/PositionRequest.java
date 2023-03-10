package csu.payload.admin.position;

import java.util.HashSet;
import java.util.Set;

import csu.model.admin.AffiliationHierrachy;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
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

	 @ManyToMany(mappedBy = "positions",fetch = FetchType.LAZY)
	 private Set<AffiliationHierrachy> hierarchies = new HashSet<AffiliationHierrachy>();

	public PositionRequest(@NotBlank @Size(max = 100) String name, @Size(max = 50) String shortName,
			Set<AffiliationHierrachy> hierarchies) {
		super();
		this.name = name;
		this.shortName = shortName;
		this.hierarchies = hierarchies;
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

	public Set<AffiliationHierrachy> getHierarchies() {
		return hierarchies;
	}

	public void setHierarchies(Set<AffiliationHierrachy> hierarchies) {
		this.hierarchies = hierarchies;
	}

	
}
