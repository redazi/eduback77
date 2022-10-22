package ma.emsi.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.emsi.edu.model.Matiere;

public interface MatiereRepository extends JpaRepository<Matiere , Long> {
	
	@Query("Select m from Matiere m where m.id not in(select fm.matiere.id from FormMatiere fm where fm.formation.id =?1)")
	List<Matiere> getDispoMatiere(Long formation_id);
	
	@Query("Select m from Matiere m where m.id in(select fm.matiere.id from FormMatiere fm where fm.formation.id =?1)")
	List<Matiere> getMforF(Long formation_id);

}
