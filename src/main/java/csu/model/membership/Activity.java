package csu.model.membership;

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
@Table(name = "ministry", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })

public class Activity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "church_id", nullable = true)
	private Ministry ministry;
	private AffiliationChurch church;
	
	
	public Activity(Long id, String name, Ministry ministry, AffiliationChurch church) {
		super();
		this.id = id;
		this.name = name;
		this.ministry = ministry;
		this.church = church;
	}
	
	public Activity(String name, Ministry ministry, AffiliationChurch church) {
		super();
		this.name = name;
		this.ministry = ministry;
		this.church = church;
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
	public Ministry getMinistry() {
		return ministry;
	}
	public void setMinistry(Ministry ministry) {
		this.ministry = ministry;
	}
	public AffiliationChurch getChurch() {
		return church;
	}
	public void setChurch(AffiliationChurch church) {
		this.church = church;
	}
	
	

}
