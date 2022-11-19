package ma.emsi.edu.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import ma.emsi.edu.model.Absence;
import ma.emsi.edu.model.AbsenceInfo;
import ma.emsi.edu.model.Client;
import ma.emsi.edu.model.FormMatiere;
import ma.emsi.edu.model.Formation;
import ma.emsi.edu.model.Reservation;

public interface AbsenceInfoRepository extends JpaRepository<AbsenceInfo , Long> {
	
	@Query("Select c from Client c where c.id  in(select ab.client.id from AbsenceInfo ab,Reservation r where  ab.reservation.id = ?1   )")
	List<Client> clients(long idreservation);
	@Modifying
	@Query("update AbsenceInfo u set u.absence = ?1 , u.status=?2 where  u.client.id = ?3 and u.reservation.id = ?4 " )
	void updateabsence(boolean absence, String status, long idclient,long idreservation);
	@Query("Select r from Reservation r where r.formateur.userName = ?1 and  r.absencevalider is false ")
	List<Reservation> reservationbyformateur(String nom);
	
	@Query("Select r.absence from AbsenceInfo r where r.client.id= ?1 and r.reservation.id=?2 ")
	boolean getStatusBuidclient(long  id,long idreservation);
	@Modifying
	@Query("update Reservation u set u.absencevalider = true where  u.id = ?1  " )
	void updateabsencevalider(long id);
	@Query("Select r from Reservation r where r.formateur.userName = ?1 and  r.absencevalider is true ")
	List<Reservation> reservationwithabsencevalide(String nom);
	@Query("Select a from AbsenceInfo a where a.reservation.id = ?1  ")
	List<AbsenceInfo> absenceinfobyreservation(long id);
	@Query("Select a from AbsenceInfo a where a.reservation.id = ?1 and a.status is null  ")
	List<AbsenceInfo> checkUnMarkedAbsence(long id);
	
}
