package ma.emsi.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.edu.model.Client;
import ma.emsi.edu.model.Utilisateur;

public interface ClientRepository extends JpaRepository<Client , Long>{
	Client findByUserName(String name);
}
