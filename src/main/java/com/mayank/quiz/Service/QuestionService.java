package com.mayank.quiz.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mayank.quiz.DAO.QuestionDAO;
import com.mayank.quiz.DTO.*;

@Service
public class QuestionService {

	@Autowired
	QuestionDAO questionDao;
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
		return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		
		try {
			return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> postQuestion(Question question) {
		// TODO Auto-generated method stub
		try {
			questionDao.save(question);
			return new ResponseEntity<>("Success", HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
	}

}
