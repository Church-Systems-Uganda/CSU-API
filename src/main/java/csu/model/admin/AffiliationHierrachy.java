package csu.model.admin;

import java.util.HashSet;
import java.util.Set;

import csu.model.audit.UserDateAudit;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;



@Entity
public class AffiliationHierrachy extends UserDateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;



	//name of column =affiliation
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinColumn(name = "affiliation-ID", nullable = false)
	private Affiliation affliation;

	private String name;

	private Integer level;

	@OneToMany(mappedBy = "hierarchy", cascade  = CascadeType.ALL)
	private Set<Position> levelHead = new HashSet<>();

	public AffiliationHierrachy() {
		super();
	}

	public AffiliationHierrachy(Affiliation affliation, String name, Integer level, Set<Position> levelHead) {
		super();
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

	public Affiliation getAffliation() {
		return affliation;
	}

	public void setAffliation(Affiliation affliation) {
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

	public Set<Position> getLevelHead() {
		return levelHead;
	}

	public void setLevelHead(Set<Position> levelHead) {
		this.levelHead = levelHead;
	}

	
}
