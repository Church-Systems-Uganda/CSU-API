package csu.model.admin.Church;

import csu.model.admin.AffiliationChurch;
import csu.model.admin.Position;
import csu.model.audit.DateAudit;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "churchHierrahcy")
public class ChurchHierrachy extends DateAudit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private long Tier;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "position_id", nullable = true)
	private Position levelHead;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id", nullable = true)
	private AffiliationChurch affiliationChurch;

	public ChurchHierrachy(long tier, Position levelHead) {
		super();
		Tier = tier;
		this.levelHead = levelHead;
	}

	public ChurchHierrachy() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getTier() {
		return Tier;
	}

	public void setTier(long tier) {
		Tier = tier;
	}

	public Position getLevelHead() {
		return levelHead;
	}

	public void setLevelHead(Position levelHead) {
		this.levelHead = levelHead;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AffiliationChurch getAffiliationChurch() {
		return affiliationChurch;
	}

	public void setAffiliationChurch(AffiliationChurch affiliationChurch) {
		this.affiliationChurch = affiliationChurch;
	}

}
