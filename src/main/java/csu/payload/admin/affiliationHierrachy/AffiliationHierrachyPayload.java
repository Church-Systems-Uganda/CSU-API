package csu.payload.admin.affiliationHierrachy;

import java.util.HashSet;
import java.util.Set;

import csu.model.admin.Affliation;
import csu.model.admin.Position;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

public class AffiliationHierrachyPayload {

	
	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY,cascade = { CascadeType.ALL })
    @JoinColumn(name = "affiliation_id", nullable = false)
	private Affliation affliation;

	private String name;

	private Integer level;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "hierarchy_position", joinColumns = { @JoinColumn(name = "hierarchy_id") }, inverseJoinColumns = {
	@JoinColumn(name = "position_id") })
	private Set<Position> levelHead = new HashSet<>();

	public AffiliationHierrachyPayload() {
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
