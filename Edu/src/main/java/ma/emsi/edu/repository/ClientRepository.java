package ma.emsi.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.edu.model.Client;

public interface ClientRepository extends JpaRepository<Client , Long>{

}
