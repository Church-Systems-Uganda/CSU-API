package csu.repository.general;

import org.springframework.data.jpa.repository.JpaRepository;

import csu.model.general.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
