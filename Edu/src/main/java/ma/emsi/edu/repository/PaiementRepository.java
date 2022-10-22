package ma.emsi.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.edu.model.Paiment;

public interface PaiementRepository extends JpaRepository<Paiment , Long> {

}
