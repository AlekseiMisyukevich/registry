package service.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.LectureRepository;
import model.Lecture;
import service.LectureService;

@Service
@Transactional
public class LectureServiceImpl implements LectureService {

	@Autowired
	private LectureRepository dao;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Lecture add(Lecture object) {
		return dao.save(object);
	}

	public void delete(Integer id) {
		dao.deleteById(id);		
	}	

	public Lecture updateObject(Lecture object) {
		return entityManager.merge(object);
	}

	public List<Lecture> getAll() {
		return dao.findAll();
	}

	public Lecture findStudentByFullname(String firstname, String lastname) {
		return null;
	}
}