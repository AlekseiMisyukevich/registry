package model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Students", catalog = "e_journal")
public class Student extends Man {
	
	@Embedded
	private Address homeAddress;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "student")
	private List<Exam> exams;
	
	public Student() {
		super();
	}
	
	public Student(String firstname, String lastname, Date dateOfBirth, Address address) {		
		super(firstname, lastname, dateOfBirth);
		this.homeAddress = address;		
	}	

	public void setHomeAddress(Address address) {
		this.homeAddress = address;
	}
	
	public void setFirstname (String firstname) {
		super.setFirstname(firstname);
	}
	
	public void setLastname (String lastname) {
		super.setLastname(lastname);
	}	
	
	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}
	
	public List<Exam> getExams() {
		return exams;
	}
	
	public String getFirstname () {
		return super.getFirstname();
	}
	
	public String getLastname () {
		return super.getLastname();
	}	
	
	public Date getDateOfBirth () {
		return super.getDateOfBirth();
	}
	
}