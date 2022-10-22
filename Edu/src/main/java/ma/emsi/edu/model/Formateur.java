package ma.emsi.edu.model;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("F")
public class Formateur extends Utilisateur{

	 public Formateur(){}
	
	/*
	public Formateur(Long id, String userName, String password, String nom, String prenom, int age, String email,
			String cin, byte[] picByte, boolean isActive, boolean isNotLocked, String[] autorities, List<Role> roles) {
		super(id, userName, password, nom, prenom, age, email, cin, picByte, isActive, isNotLocked, autorities, roles);
		// TODO Auto-generated constructor stub
	}*/
	
	private double salaire ;

	public Formateur(Long id, String userName, String password, String nom, String prenom, int age, String email,
			String cin, byte[] picByte, double salaire, Date dernierPaiement) {
		super(id, userName, password, nom, prenom, age, email, cin, picByte);
		this.salaire = salaire;
		this.dernierPaiement = dernierPaiement;
	}
	private Date dernierPaiement ;
	
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	public Date getDernierPaiement() {
		return dernierPaiement;
	}
	public void setDernierPaiement(Date dernierPaiement) {
		this.dernierPaiement = dernierPaiement;
	}
	@Override
	public String toString() {
		return "Formateur [salaire=" + salaire + ", dernierPaiement=" + dernierPaiement + "]";
	}
	
	

}
