package csu.model.admin.Church;

import csu.model.membership.Ministry;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "personChurchMinistry")
public class PersonChurchMinistry {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Status;

   
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ministry_id", nullable = true)
    private Ministry ministry;
     
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "personChurch_id", nullable = true)
    private PersonChurch personChurch;
    // @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "department_id", nullable = true)
    // private Department department;


	public PersonChurchMinistry() {
		super();
	}

	public PersonChurchMinistry(String status,   Ministry ministry, PersonChurch personChurch/* ,Department department*/ ) {
	
		Status = status;
		this.ministry = ministry;
		this.personChurch = personChurch;
		// this.department = department;
	}
    
    
    
}
