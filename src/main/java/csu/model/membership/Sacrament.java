package csu.model.membership;

import csu.model.admin.Affliation;
import csu.model.admin.Church;
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

	@JoinColumn(name = "affliation_id", nullable = true)
    private Affliation affliation;



    public Sacrament(String name, String prerequisite, String tier, Affliation affliation) {
        this.name = name;
        this.prerequisite = prerequisite;
        this.tier = tier;
        this.affliation = affliation;
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



    public Affliation getAffliation() {
        return affliation;
    }



    public void setAffliation(Affliation affliation) {
        this.affliation = affliation;
    }










    
}