package ma.emsi.edu.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Revue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	private Utilisateur utilisateur;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne
	private Matiere matiere;

	private Date date;

	private String commentaire;

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

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Override
	public String toString() {
		
		return "Revue [id=" + id + ", utilisateur=" + utilisateur + ", matiere=" + matiere + ", date=" + date
				+ ", commentaire=" + commentaire + "]";
	}
	
	
}
