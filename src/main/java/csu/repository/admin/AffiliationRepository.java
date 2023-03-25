package csu.repository.admin;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import csu.model.admin.Affiliation;

public interface AffiliationRepository extends JpaRepository<Affiliation, Long> {
	Optional<Affiliation> findByName(String name);

	Boolean existsByName(String name);
	
	//get related info about the affiliation
	
	
}
