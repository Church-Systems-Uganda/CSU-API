package csu.payload.admin.locationContact;

import csu.model.general.Person;
import csu.model.admin.locationContact.Country;
import csu.model.admin.locationContact.District;
import csu.model.admin.locationContact.Region;

public class LocationRequest {
	private Long id;		

	private Person person;

	private District district;

	private Country country;

	private Region region;

	public LocationRequest(Person person, District district,
			Country country, Region region) {
		super();
		this.person = person;
		this.district = district;
		this.country = country;
		this.region = region;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
	
	

}
