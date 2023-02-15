package csu.model.finaceProjects;

import csu.model.admin.Church;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "churchExpenditure")
public class ChurchExpenditure {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id", nullable = true)
	private Project project;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "church_id", nullable = true)
	private Church church;
    
    
    
    public ChurchExpenditure(Project project, Church church, String expenditureType) {
		super();
		this.project = project;
		this.church = church;
		ExpenditureType = expenditureType;
	}

	public ChurchExpenditure() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Church getChurch() {
		return church;
	}

	public void setChurch(Church church) {
		this.church = church;
	}

	public String getExpenditureType() {
		return ExpenditureType;
	}

	public void setExpenditureType(String expenditureType) {
		ExpenditureType = expenditureType;
	}

	private String ExpenditureType;


    
    
}
