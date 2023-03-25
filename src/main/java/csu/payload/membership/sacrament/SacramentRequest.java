package csu.payload.membership.sacrament;

import csu.model.admin.Affiliation;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class SacramentRequest {

	
	private Long id;
    private String name;
    private String prerequisite;
    private String tier;
    

     
    @ManyToOne(fetch = FetchType.LAZY)

	@JoinColumn(name = "affliation_id", nullable = true)
    private Affiliation affiliation;



   

	public SacramentRequest(Long id, String name, String prerequisite, String tier, Affiliation affliation) {
		super();
		this.id = id;
		this.name = name;
		this.prerequisite = prerequisite;
		this.tier = tier;
		this.affiliation = affiliation;
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



    public void setAffliation(Affiliation affliation) {
        this.affiliation = affliation;
    }
}
