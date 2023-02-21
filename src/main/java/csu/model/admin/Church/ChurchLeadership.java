package csu.model.admin.Church;

import java.util.Date;

import csu.model.audit.DateAudit;
import csu.model.membership.Ministry;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "churchLeadership")
public class ChurchLeadership  extends DateAudit{
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "churchHierrachy_id", nullable = true)
    private ChurchHierrachy churchHierrachy;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ministry_id", nullable = true)
    private Ministry ministry;

    private String Status;

    @NotNull
    private Date fromDate;
    
    @NotNull
    private Date toDate;

	public ChurchLeadership(ChurchHierrachy churchHierrachy, Ministry ministry, String status, @NotNull Date fromDate,
			@NotNull Date toDate) {
		super();
		this.churchHierrachy = churchHierrachy;
		 this.ministry = ministry;
		Status = status;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public ChurchLeadership() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ChurchHierrachy getChurchHierrachy() {
		return churchHierrachy;
	}

	public void setChurchHierrachy(ChurchHierrachy churchHierrachy) {
		this.churchHierrachy = churchHierrachy;
	}

	public Ministry getMinistry() {
		return ministry;
	}

	public void setMinistry(Ministry ministry) {
		this.ministry = ministry;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	
    
    
    
}
