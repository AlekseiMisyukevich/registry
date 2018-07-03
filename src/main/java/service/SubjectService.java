package service;

import model.Subject;

public interface SubjectService extends GenericService < Subject > {	
	
	public Subject findByName (String name);
	
}