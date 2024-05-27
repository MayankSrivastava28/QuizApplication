package com.mayank.quiz.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mayank.quiz.DAO.QuizDao;
import com.mayank.quiz.DTO.Quiz;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizdao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		Quiz quiz = new Quiz();
//		quiz.setTitle(title);
		return null;
	}

}
