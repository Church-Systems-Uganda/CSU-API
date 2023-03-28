package csu.repository.locationContact;

import org.springframework.data.jpa.repository.JpaRepository;

import csu.model.admin.locationContact.District;

public interface DistrictRepository extends JpaRepository<District, Long> {


	Boolean existsByName(String name);
	

}
