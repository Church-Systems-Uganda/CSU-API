package csu.payload.admin.PersonChurchMinistry;

import csu.model.admin.Church.PersonChurch;
import csu.model.membership.Ministry;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class PersonChurchMinistrypayload {
	public PersonChurchMinistrypayload() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}