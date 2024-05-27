package com.mayank.quiz.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mayank.quiz.DAO.QuestionDAO;
import com.mayank.quiz.DAO.QuizDao;
import com.mayank.quiz.DTO.Question;
import com.mayank.quiz.DTO.Quiz;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizdao;
	@Autowired
	QuestionDAO  questionDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizdao.save(quiz);
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

}
