package csu.repository.LocationContact;

import org.springframework.data.jpa.repository.JpaRepository;

import csu.model.admin.LocationContact.District;

public interface DistrictRepository extends JpaRepository<District, Long> {


	Boolean existsByName(String name);
	

}
