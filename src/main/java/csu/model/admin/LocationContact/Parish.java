package csu.model.admin.LocationContact;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "parish", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class Parish {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
}