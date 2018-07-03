package controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Lecture;
import service.LectureService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
@RequestMapping("/lecture")
public class LectureController {

	@Autowired
	private LectureService lectureService;
	
	private final Logger logger = LoggerFactory.getLogger(LectureController.class);	
	
	@GetMapping("/letures")
	public List<Lecture> getLectures (){
		logger.info("Rendering all lectures");
		return lectureService.getAll();
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(value="/addLecture")
	public Lecture addLecture (@RequestBody Lecture lecture) throws ParseException {
		
		logger.info("Lecture {} {} added", lecture.getFirstname(), lecture.getLastname());		
		return lectureService.add(lecture);
	}		
	
	@PutMapping("/editLecture")
	public Lecture updateLecture (@RequestBody Lecture lecture) throws ParseException {
		
		lecture = lectureService.updateObject(lecture);		
		if (lecture == null) {
			logger.info("Lecture not found");
			return null; 
		}
		
		logger.info("Lecture info updated");
		return lecture;
		
	}	
	
	@SuppressWarnings("unchecked")
	@DeleteMapping("/deleteLecture/{id}")
	public void deleteLecture (@PathVariable int id) {
		
		lectureService.delete(id);
		logger.info("Lecture with id = {} deleted", id);		
		
	}	
}
