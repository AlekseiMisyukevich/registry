package service;

import model.Student;

public interface StudentService extends GenericService < Student > {	
	
	public Student findByFullname (String firstname, String lastname);
	public Student getById (int id);
	
}