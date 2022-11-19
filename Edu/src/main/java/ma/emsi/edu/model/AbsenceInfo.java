package ma.emsi.edu.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class AbsenceInfo {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id ;
	@ManyToOne
	private Client client;
	@ManyToOne
	private Reservation reservation;
	private String status;
	private boolean absence ;
	
	public AbsenceInfo() {
		super();
	}
	public AbsenceInfo(long id, Client client, Reservation reservation, String status, boolean absence) {
		super();
		this.id = id;
		this.client = client;
		this.reservation = reservation;
		this.status = status;
		this.absence = absence;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	
	
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public boolean isAbsence() {
		return absence;
	}
	public void setAbsence(boolean absence) {
		this.absence = absence;
	}

	@Override
	public String toString() {
		return "AbsenceInfo [id=" + id + ", client=" + client + ", reservation=" + reservation + ", status=" + status
				+ ", absence=" + absence + "]";
	}
	
	

}
