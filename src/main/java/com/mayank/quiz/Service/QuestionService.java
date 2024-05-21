package com.mayank.quiz.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayank.quiz.DAO.QuestionDAO;
import com.mayank.quiz.DTO.*;

@Service
public class QuestionService {

	@Autowired
	QuestionDAO questionDao;
	public List<Question> getAllQuestions() {
		return questionDao.findAll();
	}
	
}
