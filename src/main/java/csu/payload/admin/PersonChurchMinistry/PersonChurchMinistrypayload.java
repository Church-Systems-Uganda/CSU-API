package csu.payload.admin.PersonChurchMinistry;

import csu.model.admin.Church.PersonChurch;
import csu.model.membership.Ministry;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class PersonChurchMinistrypayload {
	  private Long id;

	    private String Status;

	   
	    @ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "ministry_id", nullable = true)
	    private Ministry ministry;
	     
	    @ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "personChurch_id", nullable = true)
	    private PersonChurch personChurch;

		public PersonChurchMinistrypayload() {
			super();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getStatus() {
			return Status;
		}

		public void setStatus(String status) {
			Status = status;
		}

		public Ministry getMinistry() {
			return ministry;
		}

		public void setMinistry(Ministry ministry) {
			this.ministry = ministry;
		}

		public PersonChurch getPersonChurch() {
			return personChurch;
		}

		public void setPersonChurch(PersonChurch personChurch) {
			this.personChurch = personChurch;
		}
	    

}
