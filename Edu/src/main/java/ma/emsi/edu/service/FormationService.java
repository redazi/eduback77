package ma.emsi.edu.service;

import java.util.List;

import ma.emsi.edu.model.Formation;

public interface FormationService {

	void ajouter(Formation formation);

	void modifier(Formation formation,Long id);
	
	void supprimer(Long id);

	Formation getFormation(Long id);
	
	List<Formation> liste();
}
