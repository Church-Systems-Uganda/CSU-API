package csu.model.finaceProjects;

import java.time.LocalDate;

import csu.model.admin.AffiliationChurch;
import csu.payload.financeProjects.churchIncome.ChurchIncomePayload;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "churchIncome")
public class ChurchIncome {
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String incometype;
	private String activityname;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "church_id", nullable = true)
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
	public void add(ChurchIncomePayload churchIncomePayload) {
		// TODO Auto-generated method stub
		
	}

	
}
