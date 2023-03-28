package csu.repository.membership;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import csu.model.membership.Personsacrament;

public interface PersonsacramentRepository extends JpaRepository <Personsacrament,Long> {
	Optional<Personsacrament> findByName(String name);
    Boolean existsByName(String name);
}
