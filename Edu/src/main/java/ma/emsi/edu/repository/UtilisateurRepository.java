package ma.emsi.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.emsi.edu.model.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur  , Long>{
	
	Utilisateur findByUserName(String name);
	Utilisateur findByEmail(String email);
}
