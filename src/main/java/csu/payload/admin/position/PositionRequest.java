package csu.payload.admin.position;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PositionRequest {

private Long id;
	
	@NotNull
	@Size(max = 100)
	private String name;

	@Size(max = 50)
	private String shortName;

	public PositionRequest(@Size(max = 100) String name, @Size(max = 50) String shortName) {
		super();
		this.name = name;
		this.shortName = shortName;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
