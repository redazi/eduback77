package ma.emsi.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.emsi.edu.model.Revue;

public interface RevueRepository extends JpaRepository<Revue , Long> { 
	
	@Query("select r from Revue r where r.matiere.id=?1")
	List<Revue> getListByMatiere(Long id);

}
