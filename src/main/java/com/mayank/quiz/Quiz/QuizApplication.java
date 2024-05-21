package com.mayank.quiz.Quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mayank.quiz.DAO",
		"com.mayank.quiz.Controller",
		"com.mayank.quiz.Service",
		"com.mayank.quiz.DTO"})
@EntityScan("com.mayank.quiz.DTO")
@EnableJpaRepositories(basePackages = "com.mayank.quiz.DAO")
public class QuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}

}
