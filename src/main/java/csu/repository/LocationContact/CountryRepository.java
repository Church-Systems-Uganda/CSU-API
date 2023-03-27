package src.main.java.csu.repository.LocationContact;
import org.springframework.data.jpa.repository.JpaRepository;

import src.main.java.csu.repository.admin.Church.ChurchHierrachy;

public interface CountryRepository extends JpaRepository<ChurchHierrachy, Long> {


	Boolean existsByName(String name);
	

}
