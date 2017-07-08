package com.example.demo.persistence.repository;


import com.example.demo.persistence.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    /*@Query(value = "select distinct q from Answer a JOIN Question q where a.answerer = :username and q.id = a.question.id")
    List<Question> getMyAnswersToQuestions(@Param("username") String username);*/
}
