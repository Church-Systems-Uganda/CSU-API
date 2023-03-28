package csu.payload.admin.PersonChurch;

import csu.model.admin.AffiliationChurch;
import csu.model.general.Person;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class PersonChurchPayload {
	 private Long id;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "church_id", nullable = true)
		private AffiliationChurch church;
	    
	   
	    @ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "person_id", nullable = true)
		private Person person;


		public PersonChurchPayload() {
			super();
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public AffiliationChurch getChurch() {
			return church;
		}


		public void setChurch(AffiliationChurch church) {
			this.church = church;
		}


		public Person getPerson() {
			return person;
		}


		public void setPerson(Person person) {
			this.person = person;
		}
	    
}
