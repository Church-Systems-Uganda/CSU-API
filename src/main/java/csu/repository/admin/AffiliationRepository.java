package csu.repository.admin;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import csu.model.admin.Affliation;

public interface AffiliationRepository extends JpaRepository<Affliation, Long> {
	Optional<Affliation> findByName(String name);

	Boolean existsByName(String name);
	
	//get related info about the affiliation
	
	
}
