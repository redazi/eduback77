package ma.emsi.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.edu.model.Plannification;

public interface PlannificationRepository extends JpaRepository<Plannification, Long> {

}
