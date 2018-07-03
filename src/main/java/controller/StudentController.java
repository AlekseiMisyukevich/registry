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

import model.Student;
import service.StudentService;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	private final Logger logger = LoggerFactory.getLogger(StudentController.class);	
	
	@GetMapping("/students")
	public List<Student> getStudents (){
		logger.info("Rendering all students");
		return studentService.getAll();
	}
	
	@GetMapping("/getStudent/{id}")
	public Student getStudentById (@PathVariable int id) {
		logger.info("Returning student");
		return studentService.getById(id);
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/addStudent")
	public Student addStudent (@RequestBody Student student) {
		
		logger.info("Student {} {} added", student.getFirstname(), student.getLastname());		
		return studentService.add(student);
	}		
	
	@PutMapping("/editStudent")
	public Student updateStudent (@RequestBody Student student) {
		
		student = studentService.updateObject(student);		
		if (student == null) {
			logger.info("Student not found");
			return null; 
		}
		
		logger.info("Student info updated");
		return student;
		
	}	
	
	@SuppressWarnings("unchecked")
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent (@PathVariable int id) {
		
		studentService.delete(id);
		logger.info("Student with id = {} deleted", id);		
		
	}	
}