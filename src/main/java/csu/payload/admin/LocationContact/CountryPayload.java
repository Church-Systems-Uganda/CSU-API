package csu.payload.admin.LocationContact;



public class CountryPayload {
    private Long id;
    
    // Instance variable for the name of the country
    private String name;

    // Getter method for the id field
	public Long getId() {
		return id;
	}

    // Setter method for the id field
	public void setId(Long id) {
		this.id = id;
	}

    // Getter method for the name field
	public String getName() {
		return name;
	}

    // Setter method for the name field
	public void setName(String name) {
		this.name = name;
	}

	public CountryPayload() {
		super();
	}



}
