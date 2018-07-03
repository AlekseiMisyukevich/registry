package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {
		
	@Query(value = "select * from user inner join role on user.role_id = role.id where LOWER(user.username) = LOWER(:username)", nativeQuery = true)
	User findUserByUsername(@Param("username") String username);
	
}
