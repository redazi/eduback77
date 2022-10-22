package ma.emsi.edu.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Formation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	private String nom ; 
	private String description ;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Formation [id=" + id + ", nom=" + nom + ", description=" + description + "]";
	}
	
	
	
	
	
}
