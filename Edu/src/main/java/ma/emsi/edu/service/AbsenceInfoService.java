package ma.emsi.edu.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.emsi.edu.model.AbsenceInfo;
import ma.emsi.edu.model.Client;
import ma.emsi.edu.model.Reservation;

public interface AbsenceInfoService {
	void ajouter(AbsenceInfo absenceinfo);

	void modifier(AbsenceInfo absenceinfo,Long id);
	
	void supprimer(Long id);
	byte[] decompressBytes(byte[] data);
	void updateabsence(boolean absence, String status, long id,long idreservation);
	boolean getStatusBuidclient(long  id,long idreservation);
	void updateabsencevalider(long id);
	byte[] compressBytes(byte[] data);
	AbsenceInfo getAbsenceInfo(Long id);
	List<Reservation> listereservation(String nom);
	List<AbsenceInfo> liste();
	List<Client> listeEtudiant(long idreservation);
	List<Reservation> reservationwithabsencevalide(String nom);
	List<AbsenceInfo> absenceinfobyreservation(long id);

}
