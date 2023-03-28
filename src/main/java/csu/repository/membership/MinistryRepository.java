package csu.repository.membership;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import csu.model.admin.Affiliation;
import csu.model.membership.Ministry;


public interface MinistryRepository extends JpaRepository<Ministry,Long> {
	Optional<Affiliation> findByName(String name);
	Boolean existsByName(String name);
	
}
