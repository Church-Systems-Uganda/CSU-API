package csu.repository.membership;

import org.springframework.data.jpa.repository.JpaRepository;

import csu.model.membership.Ministry;


public interface MinistryRepository extends JpaRepository<Ministry,Long> {

	Boolean existsByName(String name);
	
}
