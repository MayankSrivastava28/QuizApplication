package com.mayank.quiz.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mayank.quiz.DTO.Question;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer>{
//	public List<Question> findAll();

}
