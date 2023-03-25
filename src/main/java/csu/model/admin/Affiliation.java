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
public class Affiliation extends UserDateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 100)
	private String name;

	@Size(max = 50)
	private String shortName;

	// One affiliation can have many churches
	@OneToMany(mappedBy = "affiliation", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<AffiliationChurch> churches = new HashSet<>();

	public Affiliation() {
		super();
	}

	public Affiliation(@NotBlank @Size(max = 100) String name, @Size(max = 50) String shortName) {
		super();
		this.name = name;
		this.shortName = shortName;
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

	public Set<AffiliationChurch> getChurches() {
		return churches;
	}

	public void setChurches(Set<AffiliationChurch> churches) {
		this.churches = churches;
	}

}
