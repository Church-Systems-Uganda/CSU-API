package csu.model.membership;

import csu.model.admin.Affiliation;
import csu.model.admin.AffiliationChurch;
import csu.model.audit.DateAudit;
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
@Table(name = "sacrament", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })

public class Sacrament extends DateAudit{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String name;
    private String prerequisite;
    private String tier;
    

     
    @ManyToOne(fetch = FetchType.LAZY)

	@JoinColumn(name = "affiliation_id", nullable = true)
    private Affiliation affiliation;



    public Sacrament(String name, String prerequisite, String tier, Affiliation affiliation) {
        this.name = name;
        this.prerequisite = prerequisite;
        this.tier = tier;
        this.affiliation = affiliation;
    }

   

    public Sacrament() {
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



    public String getPrerequisite() {
        return prerequisite;
    }



    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }



    public String getTier() {
        return tier;
    }



    public void setTier(String tier) {
        this.tier = tier;
    }



    public Affiliation getAffliation() {
        return affiliation;
    }



    public void setAffliation(Affiliation affiliation) {
        this.affiliation = affiliation;
    }










    
}