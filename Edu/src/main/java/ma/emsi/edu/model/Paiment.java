package ma.emsi.edu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Paiment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ; 
	@ManyToOne
    @JoinColumn(name = "panier_id", referencedColumnName = "id")
	private Panier panier ;
	private int duree ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	@Override
	public String toString() {
		return "Paiment [id=" + id + ", panier=" + panier + ", duree=" + duree + "]";
	}
	
	
}
