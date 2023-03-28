package csu.repository.locationContact;

import org.springframework.data.jpa.repository.JpaRepository;

import csu.model.admin.locationContact.Country;
import csu.payload.admin.locationContact.CountryRequest;
import jakarta.validation.Valid;


public interface CountryRepository extends JpaRepository<Country,Long> {
	Boolean existsByName(String name);

	Country saveAll(@Valid CountryRequest request);
}
