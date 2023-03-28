package csu.model.admin.locationContact;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

// Define the entity class and specify its table name and unique constraint
@Entity
@Table(name = "parish", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class Parish {
	
	// Define the primary key attribute and its generation strategy
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Define the name attribute and its corresponding getter and setter methods
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// Define the constructors, one with no arguments and another that takes a name parameter
	public Parish() {
		super();
	}
	
	public Parish(String name) {
		super();
		this.name = name;
	}
}
