package csu.repository.financeProject;

import org.springframework.data.jpa.repository.JpaRepository;

import csu.model.finaceProjects.ChurchExpenditure;

public
 interface ChurchExpenditureRepository extends JpaRepository<ChurchExpenditure,Long>{
    
}
