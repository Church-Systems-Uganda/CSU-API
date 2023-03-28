package csu.payload.admin.locationContact;


public class ParishRequest {
	private Long id;
    
	private String name;
	
public ParishRequest(String name) {
		
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
