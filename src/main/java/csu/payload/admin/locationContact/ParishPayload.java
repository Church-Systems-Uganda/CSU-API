package csu.payload.admin.locationContact;

import csu.model.admin.locationContact.Parish;

public class ParishPayload {
    private Long id;
	
	
	private String name;
	private Parish parish;
	
	
	public ParishPayload(Long id, String name, Parish parish) {
		super();
		this.id = id;
		this.name = name;
		this.parish = parish;
	}

	public Parish getParish() {
		return parish;
	}

	public void setParish(Parish parish) {
		this.parish = parish;
	}

	public ParishPayload() {
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

}
