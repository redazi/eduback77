package ma.emsi.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.edu.model.Formation;

public interface FormationRepository extends JpaRepository<Formation , Long> {

}
