package ma.emsi.edu.service;

import java.util.List;

import ma.emsi.edu.model.Matiere;

public interface MatiereService {

	void ajouter(Matiere matiere);

	void modifier(Matiere matiere, Long id);
	
	void supprimer(Long id);

	Matiere getMatiere(Long id);
	
	List<Matiere> liste();
	
	List<Matiere> getDispoMatiere(Long formation_id);
	
	List<Matiere> getMforF(Long formation_id);

}
