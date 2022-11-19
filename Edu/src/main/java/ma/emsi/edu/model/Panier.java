package ma.emsi.edu.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import ma.emsi.edu.service.PlannificationServiceImpl;

@Entity
public class Panier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	@ManyToOne
	private Client client;
	@ManyToOne 

	private Plannification planification ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Plannification getPlanification() {
		return planification;
	}
	public void setPlanification(Plannification planification) {
		this.planification = planification;
	}
	@Override
	public String toString() {
		return "Panier [id=" + id + ", client=" + client + ", planification=" + planification + "]";
	}
	
	
	
	
	
}
