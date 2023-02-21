package csu.model.admin.Church;

import csu.model.admin.Church;
import csu.model.audit.DateAudit;
import csu.model.general.Person;
import jakarta.persistence.Entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "personChurch") 
public class PersonChurch extends DateAudit {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "church_id", nullable = true)
	private Church church;
    
   
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id", nullable = true)
	private Person person;
// constructors
    
	public PersonChurch(Church church, Person person) {
	super();
	this.church = church;
	this.person = person;
}

    public PersonChurch() {
	super();
}


	//setter and getters
	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}

	public Church getChurch() {
		return church;
	}

	public void setChurch(Church church) {
		this.church = church;
	}

	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}

    
}
