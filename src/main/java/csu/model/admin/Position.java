package csu.model.admin;

import java.util.HashSet;
import java.util.Set;

import csu.model.audit.DateAudit;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "positions", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class Position extends DateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 100)
	private String name;

	@Size(max = 50)
	private String shortName;

	 @ManyToMany(mappedBy = "positions",fetch = FetchType.LAZY)
	 private Set<AffiliationHierrachy> hierarchies = new HashSet<AffiliationHierrachy>();
	 
	public Position() {
		super();
	}
	

	public Position(@NotBlank @Size(max = 100) String name, @Size(max = 50) String shortName,
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


	//adds the hierachy to position
	public void addHierarchy(AffiliationHierrachy hierarchy) {
	    hierarchies.add(hierarchy);
	    hierarchy.getLevelHead().add(this);
	}
	//removes the hierachy to position
	public void RemoveHierarchy(AffiliationHierrachy hierarchy) {
	    hierarchies.remove(hierarchy);
	    hierarchy.getLevelHead().remove(this);
	}
}
