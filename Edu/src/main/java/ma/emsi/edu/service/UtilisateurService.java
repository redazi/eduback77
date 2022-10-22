package ma.emsi.edu.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import ma.emsi.edu.model.Utilisateur;

public interface UtilisateurService extends UserDetailsService {
	
	void ajouter(Utilisateur utilisateur);

	void modifier(Utilisateur utilisateur, Long id);
	
	void supprimer(Long id);

	Utilisateur getUtilisateur(Long id);
	
	List<Utilisateur> liste();

}
