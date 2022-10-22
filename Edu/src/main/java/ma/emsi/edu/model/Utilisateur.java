package ma.emsi.edu.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type")
public class Utilisateur  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String userName;
	@Column(nullable = false)
	private String password;
	
	private String nom ; 
	private String prenom ;
	private int age ; 
	private String email ;
	private String cin ;
	
	@Column(name = "picByte", length = 100000)
	private byte[] picByte;
	
	private boolean isActive ;
	private boolean isNotLocked ;
	
	private String[] autorities ;

	public Utilisateur(String userName, String password, String nom, String prenom, int age, String email, String cin,
			boolean isActive, boolean isNotLocked, List<Role> roles) {
		super();
		this.userName = userName;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.email = email;
		this.cin = cin;
		this.isActive = isActive;
		this.isNotLocked = isNotLocked;
		this.roles = roles;
	}
/*	
	public Utilisateur(Long id, String userName, String password, String nom, String prenom, int age, String email,
			String cin,  byte[] picByte) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.email = email;
		this.cin = cin;
		this.picByte = picByte;
	}*/
	public String[] getAutorities() {
		return autorities;
	}
	public void setAutorities(String[] autorities) {
		this.autorities = autorities;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isNotLocked() {
		return isNotLocked;
	}
	public void setNotLocked(boolean isNotLocked) {
		this.isNotLocked = isNotLocked;
	}
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private List<Role> roles;
	
	
	public Utilisateur() {

	}
	
	


	public Utilisateur(Long id, String userName, String password, String nom, String prenom, int age, String email,
			String cin, byte[] picByte) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.email = email;
		this.cin = cin;
		this.picByte = picByte;
	
	}
	public Utilisateur(Long id, String userName, String password, String nom, String prenom, int age, String email,
			String cin, boolean isActive, boolean isNotLocked, String[] autorities, List<Role> roles) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.email = email;
		this.cin = cin;

		this.isActive = isActive;
		this.isNotLocked = isNotLocked;
		this.autorities = autorities;
		this.roles = roles;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public String getNom() {
		return nom;
	}
	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}


	

	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", userName=" + userName + ", password=" + password + ", nom=" + nom
				+ ", prenom=" + prenom + ", age=" + age + ", email=" + email + ", cin=" + cin + ", isActive=" + isActive
				+ ", isNotLocked=" + isNotLocked + ", autorities=" + Arrays.toString(autorities) + ", roles=" + roles
				+ "]";
	}
	
	
	
	
	
}
