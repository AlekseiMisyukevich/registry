package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.Student;

@Repository
public interface StudentRepository extends JpaRepository < Student, Integer > {	
	
	@Query(value = "SELECT * FROM Students WHERE LOWER(firstname) = LOWER(:firstname) AND LOWER(lastname) = LOWER(:lastname)", nativeQuery = true)
	public Student findByFullname (@Param("firstname") String firstname, @Param("lastname") String lastname);
	
	@Query(value = "SELECT * FROM Students WHERE id = :id", nativeQuery = true)
	public Student getById (@Param("id") int id);
	
}
