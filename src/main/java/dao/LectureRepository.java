package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Lecture;

@Repository
public interface LectureRepository extends JpaRepository< Lecture, Integer > { }
