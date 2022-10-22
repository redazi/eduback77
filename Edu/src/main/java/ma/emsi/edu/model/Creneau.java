package ma.emsi.edu.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Creneau {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	private Time heureDebut ;
	
	private Time heureFin ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Time getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(Time heureDebut) {
		this.heureDebut = heureDebut;
	}
	public Time getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(Time heureFin) {
		this.heureFin = heureFin;
	}
	@Override
	public String toString() {
		return "Creneau [id=" + id + ", heureDebut=" + heureDebut + ", heureFin=" + heureFin + "]";
	}
	
	
	

}
