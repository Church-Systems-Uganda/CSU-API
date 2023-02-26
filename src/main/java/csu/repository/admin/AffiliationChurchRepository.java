package csu.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import csu.model.admin.AffiliationChurch;

public interface AffiliationChurchRepository extends JpaRepository<AffiliationChurch,Long>{
	Boolean existsByName(String name);
}
