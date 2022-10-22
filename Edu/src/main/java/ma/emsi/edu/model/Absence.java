package ma.emsi.edu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Absence {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id ;
	private boolean absence ;
	
	@ManyToOne
    @JoinColumn(name = "Utilisateur_id", referencedColumnName = "id")
    private Utilisateur utilisateur;
	
	@ManyToOne
    @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    private Reservation reservation;

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public boolean isAbsence() {
		return absence;
	}
	public void setAbsence(boolean absence) {
		this.absence = absence;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	@Override
	public String toString() {
		return "Absence [id=" + id + ", utilisateur=" + utilisateur + ", absence=" + absence + ", reservation="
				+ reservation + "]";
	}
		

}
