package ma.emsi.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.emsi.edu.model.Panier;
import ma.emsi.edu.model.Plannification;
import ma.emsi.edu.model.Reservation;

public interface PanierRepository extends JpaRepository<Panier , Long> {
	@Query
	("Select p from Panier p where p.client.id = ?1")
	List<Panier> getPlanificationByClient(Long id);
	@Query
	("Select p from Panier p where p.client.id = ?1 and p.planification.id=?2")
	List<Panier> checkIfDejaExist(Long id,Long id1);
	@Query
	("Select p.plannification.id from Reservation p where p.id = ?1 ")
	Long GetPlanificationByRes(Long id);
}
