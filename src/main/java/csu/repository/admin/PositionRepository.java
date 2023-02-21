package csu.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import csu.model.admin.Position;

public interface PositionRepository extends JpaRepository<Position,Long> {

	
}
