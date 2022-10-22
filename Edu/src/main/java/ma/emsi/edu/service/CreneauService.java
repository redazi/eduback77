package ma.emsi.edu.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import ma.emsi.edu.model.Creneau;
import ma.emsi.edu.model.Salle;


public interface CreneauService {
	
	void ajouter(Creneau creneau);

	void modifier(Creneau creneau,Long id);
	
	void supprimer(Long id);

	Creneau getCreneau(Long id);
	
	List<Creneau> liste();
	public List<Creneau> findDispo(Salle salle , Date d);

}
