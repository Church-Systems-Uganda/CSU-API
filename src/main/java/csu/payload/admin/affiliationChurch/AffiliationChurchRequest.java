package csu.payload.admin.affiliationChurch;

import java.util.HashSet;
import java.util.Set;

import csu.model.admin.AffiliationHierrachy;
import csu.model.admin.Affliation;
import csu.model.admin.Church.ChurchHierrachy;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AffiliationChurchRequest {

	private Long id;

	@NotBlank
	@Size(max = 100)
	private String name;

	//church affiliation, a single church belongs to one affiliation
	@ManyToOne
	@JoinColumn(name = "affiliation_id", nullable = false)
	private Affliation affiliation;

	@OneToMany(mappedBy = "church", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<ChurchHierrachy> hierarchies = new HashSet<>();

	public AffiliationChurchRequest(@NotBlank @Size(max = 100) String name, Affliation affiliation,
			Set<ChurchHierrachy> hierarchies) {
		super();
		this.name = name;
		this.affiliation = affiliation;
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

	public Affliation getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(Affliation affiliation) {
		this.affiliation = affiliation;
	}

	public Set<ChurchHierrachy> getHierarchies() {
		return hierarchies;
	}

	public void setHierarchies(Set<ChurchHierrachy> hierarchies) {
		this.hierarchies = hierarchies;
	}

	
}
