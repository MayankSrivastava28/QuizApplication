package com.mayank.quiz.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mayank.quiz.DAO.QuestionDAO;
import com.mayank.quiz.DAO.QuizDao;
import com.mayank.quiz.DTO.Question;
import com.mayank.quiz.DTO.QuestionWrapper;
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

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(int id) {
		// TODO Auto-generated method stub
		 Optional<Quiz> quiz = quizdao.findById(id);
		 List<Question> questionsFromDB = quiz.get().getQuestions();
		 List<QuestionWrapper> questionForUser = new ArrayList<>();
		 for(Question q : questionsFromDB) {
			 QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(), 
					 q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			 questionForUser.add(qw);
		 }
		 return new ResponseEntity<List<QuestionWrapper>>(questionForUser, HttpStatus.OK);
	}

}
