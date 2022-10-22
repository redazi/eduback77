package ma.emsi.edu.service;

import java.util.List;


import ma.emsi.edu.model.FormMatiere;

public interface FormMatiereService {
	
	void ajouter(FormMatiere formMatiere);

	void modifier(FormMatiere formMatiere,Long id);
	
	void supprimer(Long id);

	FormMatiere getFormMatiere(Long id);
	
	List<FormMatiere> liste();
	
	FormMatiere getfm(Long idf , Long idm);

}
