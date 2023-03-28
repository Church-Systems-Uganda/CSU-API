package csu.payload.admin.locationContact;

public class RegionRequest {
	  private Long id;
	    
	   private String name;

	public RegionRequest(String name) {
		
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	   
}

