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
@Table(name = "Lectures", catalog = "e_journal")

public class Lecture extends Man {	 

	 @Embedded
	 private Address homeAddress; 
	 
	 @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "student")
	 private List<Exam> exams;	
	 
	 public Lecture () {
		 super();
	 }
	 
	 public Lecture (String firstname, String lastname, Date dateOfBirth, Address address) {
	    
		super (firstname, lastname, dateOfBirth);
	    this.homeAddress = address;
	    
	 }	  
	  
	 public void setFirstname (String firstname) {
		super.setFirstname(firstname);
	 }
	  
	 public void setLastname (String lastname) {
		super.setLastname(lastname);
	 }
	  
	 public void setAddress(Address address) {
		this.homeAddress = address;
	 }
	  
	 public void setExams (List<Exam> exams) {
		 this.exams = exams;
	 }
	 
	 public Address getAddress() {
		 return homeAddress;
	 }
	  
	 public int getId () {
		 return super.getId();
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
	  
	  public List<Exam> getExams () {
		  return exams;
	  }
	
}
