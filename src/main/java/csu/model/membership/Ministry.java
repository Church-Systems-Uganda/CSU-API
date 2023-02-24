package csu.model.membership;

import csu.model.admin.AffiliationChurch;
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


@Entity
@Table(name = "ministry", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })

public class Ministry extends DateAudit{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String name;

     
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "church_id", nullable = true)
    private AffiliationChurch church;

	public Ministry(String name, AffiliationChurch church) {
		super();
		
		this.name = name;
	}

	public Ministry() {
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

    public void setChurch(AffiliationChurch church) {
		this.church = church;
	}

	public AffiliationChurch getChurch() {
		return church;
	}
    








    
}
