package ma.emsi.edu.service;

import java.util.List;

import ma.emsi.edu.model.PaimentFormateur;

public interface PaiementFormateurService {

	void ajouter(PaimentFormateur paimentFormateur);

	void modifier(PaimentFormateur paimentFormateur,Long id);
	
	void supprimer(Long id);

	PaimentFormateur getPaimentFormateur(Long id);
	
	List<PaimentFormateur> liste();
}
