package ma.emsi.edu.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Panier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	@ManyToOne
	private Utilisateur util;
	@OneToMany
	private List<Formation> formation ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Utilisateur getUtil() {
		return util;
	}
	public void setUtil(Utilisateur util) {
		this.util = util;
	}
	public List<Formation> getFormation() {
		return formation;
	}
	public void setFormation(List<Formation> formation) {
		this.formation = formation;
	}
	@Override
	public String toString() {
		return "Panier [id=" + id + ", util=" + util + ", formation=" + formation + "]";
	}
	
	
	
}
