package csu.payload.financeProjects.personFinance;

import csu.model.admin.AffiliationChurch;
import csu.model.general.Person;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class PersonFinancePayload {
	
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Person_id", nullable = true)
	private Person person;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "church_id", nullable = true)
	private AffiliationChurch church;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	public AffiliationChurch getChurch() {
		return church;
	}


	public void setChurch(AffiliationChurch church) {
		this.church = church;
	}
	
	

}
