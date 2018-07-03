package service;

import model.Lecture;

public interface LectureService extends GenericService < Lecture > {	
	
	public Lecture findStudentByFullname (String firstname, String lastname);
	
}
