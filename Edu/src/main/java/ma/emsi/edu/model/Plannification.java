package ma.emsi.edu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plannification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	private String description ;
	
	private String type ;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Plannification [id=" + id + ", description=" + description + ", type=" + type + "]";
	}

	
	
	
}
