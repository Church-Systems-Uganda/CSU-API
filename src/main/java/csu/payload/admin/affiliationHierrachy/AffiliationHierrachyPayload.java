package csu.payload.admin.affiliationHierrachy;

import java.util.HashSet;
import java.util.Set;

import csu.model.admin.Affiliation;
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
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

public class AffiliationHierrachyPayload {

	
	private Long id;

	
	//name of column =affiliation
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinColumn(name = "affiliation-ID", nullable = false)
	private Affiliation affiliation;

	private String name;

	private Integer level;

	@OneToMany(mappedBy = "hierarchy", cascade  = CascadeType.ALL)
	private Set<Position> levelHead = new HashSet<>();

	public AffiliationHierrachyPayload() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Affiliation getAffliation() {
		return affiliation;
	}

	public void setAffliation(Affiliation affiliation) {
		this.affiliation = affiliation;
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
