package ma.emsi.edu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.emsi.edu.model.FormMatiere;

public interface FormMatiereRepository extends  JpaRepository<FormMatiere , Long>{
	
	@Query("select fm from FormMatiere fm where fm.formation.id = ?1 and fm.matiere.id = ?2")
	FormMatiere getfm(Long idf , long idm);

}
