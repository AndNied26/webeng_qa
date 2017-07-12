package com.example.demo.persistence.repository;


import com.example.demo.persistence.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * A class for setting up a repository for storing question-entities.
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
