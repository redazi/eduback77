package ma.emsi.edu.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private Formateur formateur;

	@ManyToOne
	private Utilisateur utilisateur;

	@ManyToOne
	@JoinColumn(name = "matiere_id", referencedColumnName = "id")
	private Matiere matiere;

	@ManyToOne
	private Salle salle;
	@ManyToOne

	@JoinColumn(name = "creneau_id", referencedColumnName = "id")
	private Creneau creneau;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	private String Desription;
	private boolean absencevalider ;
	private boolean etat = true;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datefin;

	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne
	private Plannification plannification;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
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

	public Plannification getPlannification() {
		return plannification;
	}

	public void setPlannification(Plannification plannification) {
		this.plannification = plannification;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", formateur=" + formateur + ", utilisateur=" + utilisateur + ", matiere="
				+ matiere + ", salle=" + salle + ", creneau=" + creneau + ", date=" + date + ", Desription="
				+ Desription + ", etat=" + etat + ", datefin=" + datefin + ", plannification=" + plannification + "]";
	}
	
	



	
	

}
