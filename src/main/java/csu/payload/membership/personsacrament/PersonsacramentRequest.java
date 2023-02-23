package csu.payload.membership.personsacrament;

import java.sql.Date;

import csu.model.admin.Church;
import csu.model.general.Person;
import csu.model.membership.Sacrament;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class PersonsacramentRequest {
	
	private Long id;
    private String name;
    private Date date;
    private String tier;

    @ManyToOne(fetch = FetchType.LAZY)

	@JoinColumn(name = "person_id", nullable = true)
    private Person person;

    @JoinColumn(name = "sacrement_id", nullable = true)
    private Sacrament sacrement;

    @JoinColumn(name = "church_id", nullable = true)
    private Church church;

   
    public PersonsacramentRequest(Long id, String name, Date date, String tier, Person person, Sacrament sacrement,
			Church church) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.tier = tier;
		this.person = person;
		this.sacrement = sacrement;
		this.church = church;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Sacrament getSacrement() {
        return sacrement;
    }

    public void setSacrement(Sacrament sacrement) {
        this.sacrement = sacrement;
    }

    public Church getChurch() {
        return church;
    }

    public void setChurch(Church church) {
        this.church = church;
    }

}