package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.Role;

@Repository
public interface RoleRepository extends JpaRepository <Role, Integer> {
	
	Role findRoleById(Integer id);
	
}
