package com.mayank.quiz.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mayank.quiz.DTO.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
