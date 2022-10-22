package ma.emsi.edu.register;

import java.util.List;

public class SignupRequest {
	
	
    private String username;
  private String nom ;
  private String prenom ;
  private String cin ;
  private int age ;
   
   
    private String email;
    
    private List<String> role;
    
    private String password;
  
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public List<String> getRole() {
      return this.role;
    }
    
    public void setRole(List<String> role) {
      this.role = role;
    }

	public String getNom() {
		return nom;
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

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
    
}
