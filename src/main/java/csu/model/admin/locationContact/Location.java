package csu.model.admin.locationContact;

import csu.model.general.Person;
import csu.payload.admin.locationContact.LocationPayload;
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
@Table(name = "countries", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class Location {
// The primary key for the location entity, generated automatically.	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
 // The person associated with this location (can be null).
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id", nullable = true)
    private Person person;

 // The district associated with this location (can be null).
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "district_id", nullable = true)
    private District district;
    
 // The country associated with this location (can be null).
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id", nullable = true)
    private Country country;

 // The region associated with this location (can be null).
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id", nullable = true)
	private Region region;

	public Location(Person person, District district, Country country, Region region) {
		super();
		this.person = person;
		this.district = district;
		this.country = country;
		this.region = region;
	}

	public Location(Long id, Person person, District district, Country country, Region region) {
		super();
		this.id = id;
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

	public void add(LocationPayload payload) {
		// TODO Auto-generated method stub
		
	}
    
}