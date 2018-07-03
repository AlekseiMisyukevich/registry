package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository < Subject, Integer > { }