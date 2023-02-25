package csu.payload.admin.churchHierrachy;

import csu.model.admin.Position;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ChurchHierrachyRequest {
   
    private Long id;

    
    private long Tier;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "position_id", nullable = true)
    private Position levelHead;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ChurchHierrachyRequest(long tier, Position levelHead, String name) {
		super();
		Tier = tier;
		this.levelHead = levelHead;
		this.name = name;
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
    
    
}
