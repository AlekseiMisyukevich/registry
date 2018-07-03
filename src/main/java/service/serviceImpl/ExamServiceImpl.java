package service.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ExamRepository;
import model.Exam;
import service.ExamService;

@Service
@Transactional
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamRepository dao;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Exam add(Exam object) {		
		return dao.save(object);
	}

	public void delete(Integer id) {
		dao.deleteById(id);
	}

	public Exam updateObject(Exam object) {
		return entityManager.merge(object);
	}

	public List< Exam > getAll() {
		return dao.findAll();
	}
	
}
