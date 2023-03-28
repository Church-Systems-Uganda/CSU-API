package csu.model.finaceProjects;

import java.time.LocalDate;

import csu.model.admin.AffiliationChurch;
import csu.model.general.Person;
import csu.payload.financeProjects.personFinance.PersonFinancePayload;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class PersonFinance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Person person;
	private String incometype;
	private String paymenttype;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "church_id", nullable = true)
	private AffiliationChurch church;
	private LocalDate date;
	
	public PersonFinance(Long id, Person person, String incometype, String paymenttype, AffiliationChurch church,
			LocalDate date) {
		super();
		this.id = id;
		this.person = person;
		this.incometype = incometype;
		this.paymenttype = paymenttype;
		this.church = church;
		this.date = date;
	}


	public PersonFinance(Person person, String incometype, String paymenttype, AffiliationChurch church,
			LocalDate date) {
		super();
		this.person = person;
		this.incometype = incometype;
		this.paymenttype = paymenttype;
		this.church = church;
		this.date = date;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIncometype() {
		return incometype;
	}
	public void setIncometype(String incometype) {
		this.incometype = incometype;
	}
	public String getPaymenttype() {
		return paymenttype;
	}
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}
	public AffiliationChurch getChurch() {
		return church;
	}
	public void setChurch(AffiliationChurch church) {
		this.church = church;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}


	public void add(PersonFinancePayload personFinancePayload) {
		// TODO Auto-generated method stub
		
	}

	

}
