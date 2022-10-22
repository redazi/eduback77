package ma.emsi.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.edu.model.Absence;

public interface AbsenceRepository extends JpaRepository<Absence , Long>{

}
