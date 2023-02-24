package csu.payload.admin.churchHierrachy;

import csu.model.admin.Position;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ChurcHierracyPayload {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private long Tier;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "position_id", nullable = true)
    private Position levelHead;

	
	
	
	public ChurcHierracyPayload() {
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
    
    
}
