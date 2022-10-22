package ma.emsi.edu.service;

import java.util.List;

import ma.emsi.edu.model.Plannification;

public interface PlannificationService {

	void ajouter(Plannification plannification);

	void modifier(Plannification plannification,Long id);
	
	void supprimer(Long id);

	Plannification getPlannification(Long id);
	
	List<Plannification> liste();
}
