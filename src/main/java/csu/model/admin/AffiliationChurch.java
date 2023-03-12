package csu.model.admin;


import csu.model.audit.UserDateAudit;
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
@Table(name = "churches", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class AffiliationChurch extends UserDateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 100)
	private String name;

	//church affiliation, a single church belongs to one affiliation
	@OneToOne(cascade = CascadeType.All)
private Affliation churchAffiliation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "affiliation_hierrachy_id", nullable = false)
	private AffiliationHierrachy affiliationHierrachy;


	public AffiliationChurch(@NotBlank @Size(max = 100) String name, AffiliationHierrachy affiliationHierrachy) {
		
		this.name = name;
		this.affiliationHierrachy = affiliationHierrachy;
	}

	public AffiliationChurch() {
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

	public AffiliationHierrachy getAffiliationHierrachy() {
		return affiliationHierrachy;
	}

	public void setAffiliationHierrachy(AffiliationHierrachy affiliationHierrachy) {
		this.affiliationHierrachy = affiliationHierrachy;
	}

	
}
