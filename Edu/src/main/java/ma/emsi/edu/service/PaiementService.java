package ma.emsi.edu.service;

import java.util.List;

import ma.emsi.edu.model.Paiment;

public interface PaiementService {
	
	void ajouter(Paiment paiment);

	void modifier(Paiment paiment,Long id);
	
	void supprimer(Long id);

	Paiment getPaiment(Long id);
	
	List<Paiment> liste();
}
