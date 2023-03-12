package csu.payload.admin.affiliationHierrachy;

import java.util.HashSet;
import java.util.Set;

import csu.model.admin.Affliation;
import csu.model.admin.Position;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

public class AffiliationHierrachyRequest {

	private Long id;



	//name of column =affiliation
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinColumn(name = "affiliation-ID", nullable = false)
	private Affliation affliation;

	private String name;

	private Integer level;

	@OneToMany(mappedBy = "hierarchy", cascade  = CascadeType.ALL)
	private Set<Position> levelHead = new HashSet<>();

	public AffiliationHierrachyRequest(Affliation affliation, String name, Integer level, Set<Position> levelHead) {
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

	public Affliation getAffliation() {
		return affliation;
	}

	public void setAffliation(Affliation affliation) {
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
