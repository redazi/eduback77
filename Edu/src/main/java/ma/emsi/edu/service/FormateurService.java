package ma.emsi.edu.service;

import java.util.List;

import ma.emsi.edu.model.Formateur;

public interface FormateurService {
	void ajouter(Formateur formateur);

	void modifier(Formateur formateur,Long id);
	
	void supprimer(Long id);

	Formateur getFormateur(Long id);
	byte[] decompressBytes(byte[] data);

	byte[] compressBytes(byte[] data);
	List<Formateur> liste();
}
