public class ChurchHierrachyRequest {
   
    private Long id;

    
    private long Tier;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "position_id", nullable = true)
    private Position levelHead;

	public ChurchHierrachyRequest(long tier, Position levelHead) {
		super();
		Tier = tier;
		this.levelHead = levelHead;
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
