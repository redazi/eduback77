package ma.emsi.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.emsi.edu.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role , Long> {
	 Role findByNom(String nom);
}
