package ma.emsi.edu.service;

import java.util.Date;
import java.util.List;

import ma.emsi.edu.http.Objres;
import ma.emsi.edu.model.Reservation;
import ma.emsi.edu.model.Salle;
import ma.emsi.edu.model.SalleReservation;

public interface ReservationService {
	
	Objres ajouter(Reservation reservation);

	void modifier(Reservation reservation, Long id );
	
	public void extend(Reservation reservation);
	
	void supprimer(Long id);
	
	void supprimerList(Long id);

	Reservation getReservation(Long id);
	
	List<Reservation> liste();
	
	List<Reservation> listeBySalleAndDate(Salle s , Date d);
}
