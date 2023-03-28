package csu.repository.locationContact;

import org.springframework.data.jpa.repository.JpaRepository;

import csu.model.admin.locationContact.Location;
public interface LocationRepository extends JpaRepository<Location, Long> {
	

}
