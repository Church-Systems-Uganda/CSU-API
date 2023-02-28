package csu.model.finaceProjects;

import java.time.LocalDate;

import csu.model.admin.AffiliationChurch;

public class ChurchIncome {
	private Long id;
	private String incometype;
	private String activityname;
	private AffiliationChurch church;
	private LocalDate date;
	//private Activity activity;
	
	
	public ChurchIncome() {
		super();
	}
	public ChurchIncome(Long id, 
			String incometype, 
			String activityname, 
			AffiliationChurch church, 
			LocalDate date) {
		super();
		this.id = id;
		this.incometype = incometype;
		this.activityname = activityname;
		this.church = church;
		this.date = date;
	}
	public ChurchIncome(String incometype, 
			String activityname, 
			AffiliationChurch church, 
			LocalDate date) {
		super();
		this.incometype = incometype;
		this.activityname = activityname;
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
	public String getActivityname() {
		return activityname;
	}
	public void setActivityname(String activityname) {
		this.activityname = activityname;
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

	
}
