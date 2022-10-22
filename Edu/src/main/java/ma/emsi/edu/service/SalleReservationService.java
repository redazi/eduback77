package ma.emsi.edu.service;

import java.util.List;


import ma.emsi.edu.model.SalleReservation;

public interface SalleReservationService {

	void ajouter(SalleReservation reservation);

	void modifier(SalleReservation reservation, Long id );
	
	void supprimer(Long id);

	SalleReservation getSalleReservation(Long id);
	
	List<SalleReservation> liste();
}
