package csu.repository.financeProject;

import org.springframework.data.jpa.repository.JpaRepository;

import csu.model.finaceProjects.ChurchIncome;

public interface ChurchIncomeRepository extends JpaRepository<ChurchIncome,Long>{

    
}