package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Exam;

@Repository
public interface ExamRepository extends JpaRepository < Exam, Integer > { }
