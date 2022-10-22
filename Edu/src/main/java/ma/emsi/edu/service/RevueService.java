package ma.emsi.edu.service;

import java.util.List;


import ma.emsi.edu.model.Revue;

public interface RevueService {
	
	void ajouter(Revue revue);

	void modifier(Revue revue, Long id );
	
	void supprimer(Long id);

	Revue getRevue(Long id);
	
	List<Revue> liste();
	
	List<Revue> getListByMatiere(Long id);

}
