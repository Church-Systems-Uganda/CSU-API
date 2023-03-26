// Package declaration indicating the package of the class
package csu.model.admin.LocationContact;

// Import statements for necessary classes and annotations
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

// Entity annotation indicating that this class represents a database entity
@Entity
// Table annotation specifying the name of the database table and any unique constraints
@Table(name = "countries", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class Country {
    // Id annotation indicating that this field is the primary key of the entity
    @Id
    // GeneratedValue annotation indicating that the primary key value is generated automatically
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

    // Constructor that takes in a name parameter
	public Country(String name) {
		super();
		this.name = name;
	}

    // Default constructor
	public Country() {
		super();
	}
}
