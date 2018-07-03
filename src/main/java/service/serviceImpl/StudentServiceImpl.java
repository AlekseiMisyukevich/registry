package service.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.StudentRepository;
import model.Student;
import service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
		
	@Autowired
	private StudentRepository dao;
	
	@PersistenceContext
	private EntityManager entityManager;
		
	public StudentServiceImpl () {		}
	
	@Transactional(readOnly=false)
	public Student add(Student object) {
		return dao.save(object);
	}

	@Transactional(readOnly=false)
	public void delete(Integer id) {
		dao.deleteById(id);		
	}	

	@Transactional(readOnly=false)
	public Student updateObject(Student object) {
		return entityManager.merge(object);
	}

	@Transactional(readOnly=true)
	public List<Student> getAll() {
		return dao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Student findByFullname(String firstname, String lastname) {
		return dao.findByFullname(firstname, lastname);
	}	

	@Override
	@Transactional(readOnly = true)
	public Student getById(int id) {
		return dao.getById(id);
	}
	
}
