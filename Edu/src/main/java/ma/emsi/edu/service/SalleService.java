package ma.emsi.edu.service;

import java.util.List;

import ma.emsi.edu.model.Salle;

public interface SalleService {

	void ajouter(Salle salle);

	void modifier(Salle salle, Long id);
	
	void supprimer(Long id);

	Salle getSalle(Long id);
	
	List<Salle> liste();
}
