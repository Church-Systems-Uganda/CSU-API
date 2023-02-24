package csu.model.finaceProjects;

import csu.model.admin.AffiliationChurch;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "countries", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class Project{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "church_id", nullable = true)
    private AffiliationChurch church;

	public Project() {
		super();
	}

	public Project(AffiliationChurch church) {
		super();
		this.church = church;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AffiliationChurch getChurch() {
		return church;
	}

	public void setChurch(AffiliationChurch church) {
		this.church = church;
	}

	
    
    
}