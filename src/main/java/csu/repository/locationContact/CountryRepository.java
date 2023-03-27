package csu.repository.locationContact;

import org.springframework.data.jpa.repository.JpaRepository;

import csu.model.admin.LocationContact.Country;


public interface CountryRepository extends JpaRepository<Country,Long> {
	Boolean existsByName(String name);
}
