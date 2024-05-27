package com.mayank.quiz.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mayank.quiz.DTO.Question;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer>{
//	public List<Question> findAll();
	public List<Question> findByCategory(String category);

	@Query(value = "select * from question q where q.category=:category order by Random() "
			+ "LIMIT :numQ", nativeQuery = true)
	public List<Question> findRandomQuestionsByCategory(String category, int numQ);

}
