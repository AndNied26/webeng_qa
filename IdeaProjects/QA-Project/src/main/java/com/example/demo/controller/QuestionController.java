package com.example.demo.controller;


import com.example.demo.application.dto.QuestionDto;
import com.example.demo.application.service.QuestionService;
import com.example.demo.application.service.UserService;
import com.example.demo.persistence.entity.Answer;
import com.example.demo.persistence.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qa")
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }



    @RequestMapping(method = RequestMethod.GET)
    public List<QuestionDto> getAllQuestions() {
        return questionService.getAllQuestions();
    }



    @RequestMapping(value = "/myQuestions", method = RequestMethod.GET)
    public List<QuestionDto> getMyQuestions() {
        return questionService.getMyQuestions();
    }



    @RequestMapping(value = "/unansweredQuestions", method = RequestMethod.GET)
    public List<QuestionDto> getUnansweredQuestions() {
        return questionService.getUnansweredQuestions();
    }



    @RequestMapping(value = "/unresolvedQuestions", method = RequestMethod.GET)
    public List<QuestionDto> getUnresolvedQuestions() {
        return questionService.getUnresolvedQuestions();
    }



    @RequestMapping(value = "/myAnswers", method = RequestMethod.GET)
    public List<QuestionDto> getMyAnswersToQuestions() {
        return questionService.getMyAnswersToQuestions();
    }


    @RequestMapping(value = "/setQuestion", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void setNewQuestion(@RequestBody Question question) {
        questionService.setQuestion(question);
    }



    @RequestMapping(value = "deleteQuestion", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteQuestion(@RequestBody Question question) {
           questionService.deleteQuestion(question);
    }


    @RequestMapping(value = "setAnswer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void setNewAnswer(@RequestBody Answer answer) {
        questionService.setNewAnswer(answer);
    }



    @RequestMapping(value = "/acceptAnswer", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void acceptAnswer(@RequestBody Answer answer) {
        questionService.acceptAnswer(answer);
    }


    @RequestMapping(value = "deleteAnswer", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAnswer(@RequestBody Answer answer) {
        questionService.deleteAnswer(answer);
    }

}
