package com.example.demo.controller;


import com.example.demo.application.dto.QuestionDto;
import com.example.demo.application.service.QuestionService;
import com.example.demo.persistence.entity.Answer;
import com.example.demo.persistence.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A class mapping the URLs to the methods of the service-classes.
 */
@RestController
@RequestMapping("/qa")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    /**
     * A constructor, which sets the local questionService to the actual questionService.
     *
     * @param questionService the questionService.
     */
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    /**
     * A getter-method, for all questions the application knows.
     * path: localhost:8080/qa , type: GET
     *
     * @return a list of questionDto-objects.
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<QuestionDto> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    /**
     * A getter-method, for all questions asked by the currently logged in user.
     * path: localhost:8080/qa/myQuestion , type: GET
     *
     * @return a list of questionDto-objects.
     */
    @RequestMapping(value = "/myQuestions", method = RequestMethod.GET)
    public List<QuestionDto> getMyQuestions() {
        return questionService.getMyQuestions();
    }

    /**
     * A getter-method, for all questions, which haven't been answered at all.
     * path: localhost:8080/qa/unansweredQuestions , type: GET
     *
     * @return a list of questionDto-objects.
     */
    @RequestMapping(value = "/unansweredQuestions", method = RequestMethod.GET)
    public List<QuestionDto> getUnansweredQuestions() {
        return questionService.getUnansweredQuestions();
    }

    /**
     * A getter-method for all questions, which haven't been solved yet, but may already received one or more answers.
     * path: localhost:8080/qa/unresolvedQuestions , type: GET
     *
     * @return a list of questionDto-objects.
     */
    @RequestMapping(value = "/unresolvedQuestions", method = RequestMethod.GET)
    public List<QuestionDto> getUnresolvedQuestions() {
        return questionService.getUnresolvedQuestions();
    }

    /**
     * A getter-method for all question, where the currently logged in user wrote an answer to.
     * path: localhost:8080/qa/myAnswers , type: GET
     *
     * @return a list of questionDto-objects.
     */
    @RequestMapping(value = "/myAnswers", method = RequestMethod.GET)
    public List<QuestionDto> getMyAnswersToQuestions() {
        return questionService.getMyAnswersToQuestions();
    }

    /**
     * Adds the given question to the questionRepository.
     * path: localhost:8080/qa/setQuestion , type: POST
     *
     * @param question the given question.
     */
    @RequestMapping(value = "/setQuestion", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void setNewQuestion(@RequestBody Question question) {
        questionService.setQuestion(question);
    }

    /**
     * Deletes the given question out of the questionRepository.
     * path: localhost:8080/qa/deleteQuestion , type: DELETE
     *
     * @param question the given question.
     */
    @RequestMapping(value = "/deleteQuestion", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteQuestion(@RequestBody Question question) {
           questionService.deleteQuestion(question);
    }

    /**
     * Inserts the given answer into the answerRepository and connects it to the question, it depends to.
     * path: localhost:8080/qa/setAnswer , type: POST
     *
     * @param answer the given answer.
     */
    @RequestMapping(value = "/setAnswer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void setNewAnswer(@RequestBody Answer answer) {
        questionService.setNewAnswer(answer);
    }


    /**
     * Sets the accepted-flag of the given answers to 'true'.
     * path: localhost:8080/qa/acceptAnswer , type: PUT
     *
     * @param answer the given answers.
     */
    @RequestMapping(value = "/acceptAnswer", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void acceptAnswer(@RequestBody Answer answer) {
        questionService.acceptAnswer(answer);
    }

    /**
     * Deletes the given answer out of the repository.
     * path: localhost:8080/qa/deleteAnswer , type: DELETE
     *
     * @param answer the given answer,
     */
    @RequestMapping(value = "deleteAnswer", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAnswer(@RequestBody Answer answer) {
        questionService.deleteAnswer(answer);
    }

}
