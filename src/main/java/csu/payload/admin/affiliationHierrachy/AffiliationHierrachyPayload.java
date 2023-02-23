package csu.payload.admin.affiliationHierrachy;

import csu.model.admin.Affliation;
import csu.model.admin.Position;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

public class AffiliationHierrachyPayload {

	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Affliation affliation;

	private String name;

	private Integer level;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "position_id", nullable = true)
	private Position levelHead;

	public AffiliationHierrachyPayload() {
		super();
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

	public Position getLevelHead() {
		return levelHead;
	}

	public void setLevelHead(Position levelHead) {
		this.levelHead = levelHead;
	}

}
