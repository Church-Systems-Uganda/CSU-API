package csu.model.membership;

import java.sql.Date;

import csu.model.admin.AffiliationChurch;
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
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "personSacrement", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class Personsacrament extends DateAudit{

    // Define fields for Person Sacrament entity
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String name;
    private Date date;
    private String tier;

    // Define relationship between Person Sacrament entity and other entities
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id", nullable = true)
    private Person person;

    @JoinColumn(name = "sacrement_id", nullable = true)
    private Sacrament sacrement;

    @JoinColumn(name = "church_id", nullable = true)
    private AffiliationChurch church;

    // Define constructor for Person Sacrament entity
    
    
    
    public Personsacrament(String name, Date date, String tier, Person person, Sacrament sacrement, AffiliationChurch church) {
        this.name = name;
        this.date = date;
        this.tier = tier;
        this.person = person;
        this.sacrement = sacrement;
        this.church = church;
    }

    public Personsacrament(Long id, String name, Date date, String tier, Person person, Sacrament sacrement,
			AffiliationChurch church) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.tier = tier;
		this.person = person;
		this.sacrement = sacrement;
		this.church = church;
	}

	// Define getters and setters for Person Sacrament entity fields
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

    public AffiliationChurch getChurch() {
        return church;
    }

    public void setChurch(AffiliationChurch church) {
        this.church = church;
    }
}
