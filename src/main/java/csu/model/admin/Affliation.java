package csu.model.admin;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import csu.model.audit.UserDateAudit;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "affiliations", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class Affliation extends UserDateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@OneToMany(mappedBy = "affiliation", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<AffiliationChurch> churches = new HashSet<>();
	
	public Affliation() {
		super();
	}


	public Affliation(@NotBlank @Size(max = 100) String name, @Size(max = 50) String shortName,
			Set<AffiliationHierrachy> affiliationHierrachy, Set<Position> position, Set<AffiliationChurch> churches) {
		super();
		this.name = name;
		this.shortName = shortName;
		this.affiliationHierrachy = affiliationHierrachy;
		this.position = position;
		this.churches = churches;
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


	public Set<AffiliationChurch> getChurches() {
		return churches;
	}


	public void setChurches(Set<AffiliationChurch> churches) {
		this.churches = churches;
	}

	
	
//	  public void addHierarchy(AffiliationHierrachy hierarchy) {
//	        this.affiliationHierrachy.add(hierarchy);
//	        hierarchy.setAffliation(this);
//	    }
//	    
//	    public void removeHierarchy(AffiliationHierrachy hierarchy) {
//	        this.affiliationHierrachy.remove(hierarchy);
//	        hierarchy.setAffliation(null);
//	    }
//	    
//	    public void addChurch(AffiliationChurch church) {
//	        this.churches.add(church);
//	        church.setAffiliationHierrachy(this);
//	    }
//	    
//	    public void removeChurch(AffiliationChurch church) {
//	        this.churches.remove(church);
//	        church.setAffiliationHierrachy(null);
//	    }
	
}
