package ma.emsi.edu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FormMatiere {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	@ManyToOne
	private Formation formation;
	
	@ManyToOne 
	private Matiere matiere ;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	@Override
	public String toString() {
		return "formMatiere [id=" + id + ", formation=" + formation + ", matiere=" + matiere + "]";
	}
	
	
	

}
