package csu.payload.admin.affiliation;

import jakarta.validation.constraints.Size;

public class AffiliationPayload {

	private Long id;
	
	@Size(max = 100)
	private String name;

	@Size(max = 50)
	private String shortName;

	public AffiliationPayload() {
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
