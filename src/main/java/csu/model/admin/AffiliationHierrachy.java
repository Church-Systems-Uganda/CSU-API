package csu.model.admin;



import java.util.HashSet;
import java.util.Set;

import csu.model.audit.UserDateAudit;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class AffiliationHierrachy extends UserDateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "affiliation_id")
	@JoinColumn(name="affiliationHierrachy")
	private Set<Affliation> affliation = new HashSet();

	private String name;

	private Integer level;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "position_id", nullable = true)
	private Position levelHead;

	public AffiliationHierrachy() {
		super();
	}

	public AffiliationHierrachy(@NotNull Set<Affliation> affliation, String name, Integer level, Position levelHead) {
		this.affliation = affliation;
		this.name = name;
		this.level = level;
		this.levelHead = levelHead;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Affliation> getAffliation() {
		return affliation;
	}

	public void setAffliation(Set<Affliation> affliation) {
		this.affliation = affliation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Position getLevelHead() {
		return levelHead;
	}

	public void setLevelHead(Position levelHead) {
		this.levelHead = levelHead;
	}

	
	
	

}
