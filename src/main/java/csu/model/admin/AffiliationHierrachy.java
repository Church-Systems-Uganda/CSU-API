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
import jakarta.validation.constraints.NotNull;



@Entity
public class AffiliationHierrachy extends UserDateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY,cascade = { CascadeType.ALL })

	//name of column =affiliation
    @JoinColumn(name = "affiliation", nullable = false)
	private Affliation affliation;

	private String name;

	private Integer level;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "hierarchy_position", joinColumns = { @JoinColumn(name = "hierarchy_id") }, inverseJoinColumns = {
	@JoinColumn(name = "position_id") })
	private Set<Position> levelHead = new HashSet<>();

	public AffiliationHierrachy() {
		super();
	}

	public AffiliationHierrachy(@NotNull Affliation affliation, String name, Integer level, Set<Position> levelHead) {
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

	 // add helper methods to manage positions
    public void addPosition(Position position) {
    	levelHead.add(position);
        position.getHierarchies().add(this);
    }

    public void removePosition(Position position) {
    	levelHead.remove(position);
        position.getHierarchies().remove(this);
    }

	
}
