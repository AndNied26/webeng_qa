package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * A class for setting up a repository for storing answer-entities.
 */
public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
