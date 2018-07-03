package service.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.SubjectRepository;
import model.Subject;
import service.SubjectService;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository dao;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Subject add(Subject object) {
		return dao.save(object);
	}

	public void delete(Integer id) {
		dao.deleteById(id);		
	}

	public Subject updateObject(Subject object) {
		return entityManager.merge(object);
	}

	public List<Subject> getAll() {
		return dao.findAll();
	}

	public Subject findByName(String name) {
		
		return null;
	}

}
