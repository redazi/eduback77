package ma.emsi.edu.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import ma.emsi.edu.model.Creneau;
import ma.emsi.edu.model.Plannification;
import ma.emsi.edu.model.Reservation;
import ma.emsi.edu.model.Salle;

public interface ReservationRepository extends JpaRepository<Reservation , Long> {
	
	
//	@Query("select r from Reservation r where r.salle.id = ?1 and r.date = ?2 ")
	List<Reservation> findBySalleAndDate(Salle s , Date c);
	@Modifying
	@Query("Delete from Reservation r where r.plannification.id = ?1")
	void deleteList(Long id);
	
	@Query
	("Select r from Reservation r where r.plannification.id = ?1")
	List<Reservation> findByPlannification(Long id);
	

	
}
