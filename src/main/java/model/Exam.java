package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Exams", catalog = "e_journal")
public class Exam {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;

	  @ManyToOne(fetch = FetchType.EAGER)
	  @JoinColumn(name = "studentId")
	  private Student student;
	    
	  @ManyToOne(fetch = FetchType.EAGER)
	  @JoinColumn(name = "subjectId")
	  private Subject subject;
	  
	  @ManyToOne(fetch = FetchType.EAGER)
	  @JoinColumn(name = "lectureId")
	  private Lecture lecture;

	  @Column(name = "grade")
	  private int grade;

	  public Exam (Student student, Subject subject, Lecture lecture, int grade) {
	    this.student = student;
	    this.subject = subject;
	    this.lecture = lecture;
	    this.grade = grade;
	  }
	  
	  public int getId() {
	    return id;
	  }

	  public void setId(int id) {
	    this.id = id;
	  }

	  public Student getStudent() {
	    return student;
	  }

	  public void setStudent(Student student) {
	    this.student = student;
	  }

	  public Subject getSubject() {
	    return subject;
	  }

	  public void setSubject(Subject subject) {
	    this.subject = subject;
	  }

	  public int getGrade() {
	    return grade;
	  }

	  public void setGrade(int grade) {
	    this.grade = grade;
	  }
	  
	  public Lecture getLecture () {
	    return lecture;
	  }
	  
	  public void setLecture (Lecture object) {
	    this.lecture = object;
	  }	 
	
}
