package csu.payload.admin.position;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PositionPayload {

	
	private Long id;

	@NotBlank
	@Size(max = 100)
	private String name;

	@Size(max = 50)
	private String shortName;
	
	

	public PositionPayload() {
		super();
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

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	
	
}
