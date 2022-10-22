package ma.emsi.edu.service;

import java.util.List;

import ma.emsi.edu.model.Absence;


public interface AbsenceService {

	void ajouter(Absence absence);

	void modifier(Absence absence,Long id);
	
	void supprimer(Long id);

	Absence getAbsence(Long id);
	
	List<Absence> liste();
}
