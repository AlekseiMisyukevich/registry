package controller;

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

import model.Exam;
import service.ExamService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
@RequestMapping("/exam")
public class ExamController {
	
	@Autowired
	private ExamService examService;
	
	private final Logger logger = LoggerFactory.getLogger(ExamController.class);	
	
	@GetMapping("/exams")
	public List<Exam> getAll() {
		
		logger.info("Rendering all exams");
		return examService.getAll();
		
	}
	
	@PostMapping("/addExam")
	public Exam addExam(@RequestBody Exam exam)  {
		
		examService.add(exam);
		logger.info("Exam named {} added", exam.getSubject().getName());
		return exam;	
		
	}
	
	@PutMapping
	public Exam updateExam(@RequestBody Exam exam) {
		
		logger.info("Exam under id = {} and name {} has been updated", exam.getId(), exam.getSubject().getName());
		return examService.add(exam);
	
	}
	
	@DeleteMapping
	public void deleteUser(@PathVariable Integer id) {
		
		examService.delete(id);
		logger.info("Exam under id = {} deleted", id);
			
	}
	
	
	

}
