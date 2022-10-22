package ma.emsi.edu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Salle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	@Column(unique = true)
	private String code ;
	private int nbrPlace ;
	private String type ;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getNbrPlace() {
		return nbrPlace;
	}
	public void setNbrPlace(int nbrPlace) {
		this.nbrPlace = nbrPlace;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Salle [id=" + id + ", code=" + code + ", nbrPlace=" + nbrPlace + ", type=" + type + "]";
	}
	
	
	
	

}
