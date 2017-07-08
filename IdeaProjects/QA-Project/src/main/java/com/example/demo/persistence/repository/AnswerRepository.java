package com.example.demo.persistence.repository;



import com.example.demo.persistence.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    /*@Query(value = "select a from Answer a where a.answerer = :username")
    List<Answer> getMyAnswersToQuestions(@Param("username") String username);*/
}
