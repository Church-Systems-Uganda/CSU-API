package csu.repository.membership;

import org.springframework.data.jpa.repository.JpaRepository;

import csu.model.membership.Sacrament;

public interface SacramentRepository extends JpaRepository <Sacrament, Long> {
    Boolean existsByName(String name);

}
