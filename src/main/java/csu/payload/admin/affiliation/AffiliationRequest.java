package csu.payload.admin.affiliation;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AffiliationRequest {
	
	private Long id;
	
	@NotNull
	@Size(max = 100)
	private String name;

	@Size(max = 50)
	private String shortName;

	public AffiliationRequest(@Size(max = 100) String name, @Size(max = 50) String shortName) {
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
