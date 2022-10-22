package ma.emsi.edu.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class SalleReservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	@ManyToOne
	private Utilisateur utilisateur;
	
	
	
	@ManyToOne 
	private Salle salle ;
	@ManyToOne
	
    @JoinColumn(name = "creneau_id", referencedColumnName = "id")
	private Creneau creneau;
	
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date ;
	
	private String Desription ;

	

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

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Creneau getCreneau() {
		return creneau;
	}

	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

	public String getDesription() {
		return Desription;
	}

	public void setDesription(String desription) {
		Desription = desription;
	}

	@Override
	public String toString() {
		return "SalleReservation [id=" + id + ", utilisateur=" + utilisateur + ", salle=" + salle + ", creneau="
				+ creneau + ", date=" + date + ", Desription=" + Desription + "]";
	}
	
	

	

	

	

	
	
	

}
