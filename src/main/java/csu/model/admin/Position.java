package csu.model.admin;

import java.util.HashSet;
import java.util.Set;

import csu.model.audit.DateAudit;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
// Define a unique constraint on the name column
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

	// Define a many-to-one relationship with AffiliationHierrachy, with lazy loading
	// enabled
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hierarchy_id", nullable = false)
	private AffiliationHierrachy hierarchy;

	public Position() {
		super();
	}

	public Position(@NotBlank @Size(max = 100) String name, @Size(max = 50) String shortName,
			AffiliationHierrachy hierarchy) {
		this.name = name;
		this.shortName = shortName;
		this.hierarchy = hierarchy;
	}

	// Getters and setters

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
}
