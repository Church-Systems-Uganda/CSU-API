package csu.repository.admin.singleChurch;

import org.springframework.data.jpa.repository.JpaRepository;

import csu.model.admin.singleChurch.ChurchLeadership;
import csu.model.admin.singleChurch.PersonChurchMinistry;

public interface PersonChurchMinistryRepository extends JpaRepository<PersonChurchMinistry,Long>{

}
