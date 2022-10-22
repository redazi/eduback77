package ma.emsi.edu.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PaimentFormateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	@ManyToOne
    @JoinColumn(name = "formatteur_id", referencedColumnName = "id")
	private Formateur formateur ;
	private Date dateSalaire ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Formateur getFormateur() {
		return formateur;
	}
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	public Date getDateSalaire() {
		return dateSalaire;
	}
	public void setDateSalaire(Date dateSalaire) {
		this.dateSalaire = dateSalaire;
	}
	@Override
	public String toString() {
		return "PaimentFormateur [id=" + id + ", formateur=" + formateur + ", dateSalaire=" + dateSalaire + "]";
	}
	
	

}
