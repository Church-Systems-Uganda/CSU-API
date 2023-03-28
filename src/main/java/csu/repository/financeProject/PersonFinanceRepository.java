package csu.repository.financeProject;

import org.springframework.data.jpa.repository.JpaRepository;

import csu.model.finaceProjects.PersonFinance;

public interface PersonFinanceRepository extends JpaRepository<PersonFinance, Long> {

}
