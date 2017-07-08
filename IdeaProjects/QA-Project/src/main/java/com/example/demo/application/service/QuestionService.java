package com.example.demo.application.service;



import com.example.demo.application.dto.AnswerDto;
import com.example.demo.application.dto.QuestionDto;
import com.example.demo.application.dto.RoleDto;
import com.example.demo.application.dto.UserDto;
import com.example.demo.persistence.entity.Answer;
import com.example.demo.persistence.entity.Question;
import com.example.demo.persistence.entity.Role;
import com.example.demo.persistence.entity.User;
import com.example.demo.persistence.repository.AnswerRepository;
import com.example.demo.persistence.repository.QuestionRepository;
import com.example.demo.persistence.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;
    private UserRepository userRepository;

    public QuestionService(QuestionRepository questionRepository, AnswerRepository answerRepository, UserRepository userRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
    }

    public List<QuestionDto> getAllQuestions() {
        List<Question> questions = new LinkedList<>();
        questionRepository.findAll().forEach(questions :: add);

        List<QuestionDto> allQuestions = new LinkedList<>();
        for (Question question: questions) {
            allQuestions.add(convertToDto(question));
        }
        return allQuestions;
    }

    public List<QuestionDto> getMyQuestions() {
        List<Question> questions = new LinkedList<>();
        questionRepository.findAll().forEach(questions :: add);


        User user = getMyUser();

        List<QuestionDto> myQuestions = new LinkedList<>();
        for (Question question: questions) {
            if(user == question.getQuestioner()){

                myQuestions.add(convertToDto(question));
            }

        }
        return myQuestions;
    }

    public List<QuestionDto> getUnansweredQuestions() {
        List<Question> questions = new LinkedList<>();
        questionRepository.findAll().forEach(questions :: add);

        List<QuestionDto> unansweredQuestions = new LinkedList<>();
        for (Question question: questions) {
            if(question.getAnswers().isEmpty()) {
                unansweredQuestions.add(convertToDto(question));
            }
        }
        return unansweredQuestions;
    }

    public List<QuestionDto> getUnresolvedQuestions() {
        List<Question> questions = new LinkedList<>();
        questionRepository.findAll().forEach(questions :: add);

        List<QuestionDto> unresolvedQuestions = new LinkedList<>();
        for (Question question: questions) {
            if(!question.isSolved()){
                unresolvedQuestions.add(convertToDto(question));
            }
            /*boolean accepted = false;
            List<Answer> answers = question.getAnswers();
            for(Answer answer: answers) {
                if(answer.isAccepted()){
                    accepted = true;
                }
            }
            if(!accepted){
                unresolvedQuestions.add(convertToDto(question));
            }*/
        }
        return unresolvedQuestions;
    }

    public List<QuestionDto> getMyAnswersToQuestions() {

        User user = getMyUser();


        List<Answer> answers = answerRepository.findAll();
        List<Answer> filteredAnswers = new LinkedList<>();

        for(Answer answer: answers) {
            if(answer.getAnswerer()==user){
                filteredAnswers.add(answer);
            }
        }
        List<Question> questions = new LinkedList<>();
        for(Answer answer: filteredAnswers) {
            questions.add(answer.getQuestion());
        }


        //filter the same questions
        List<Question> filteredQuestions = new LinkedList<>();
        for(Question q: questions){
            if(!filteredQuestions.contains(q)){
                filteredQuestions.add(q);
            }
        }

        List<QuestionDto> myAnswersToQuestions = new LinkedList<>();
        for (Question question: filteredQuestions) {
                myAnswersToQuestions.add(convertToDto(question));
        }
        return myAnswersToQuestions;
    }

    public void setQuestion(Question question) {

        User user = getMyUser();
        Question q = new Question(question.getTitle(), question.getText(), user);
        questionRepository.save(q);
    }

    public void deleteQuestion(Question question){

        User user = getMyUser();

        Question q = questionRepository.findOne(question.getId());

        if(q.getQuestioner() == user) {
            questionRepository.delete(q.getId());
        }

    }



    public void setNewAnswer(Answer answer){
        User user = getMyUser();
        Long l = answer.getQuestion().getId();
        Question q = questionRepository.findOne(l);
        Answer newAnswer = new Answer(answer.getText(), user, q);
        q.addAnswer(newAnswer);
        answerRepository.save(newAnswer);
        questionRepository.save(q);
    }



    //Set the given answer as accepted and the question as solved
    public void acceptAnswer(Answer answer) {

        User user = getMyUser();

        Answer a = answerRepository.findOne(answer.getId());
        Question question = a.getQuestion();

        if(user == question.getQuestioner()){
            a.setAccepted(true);
            answerRepository.save(a);

            question.setSolved(true);
            questionRepository.save(question);
        }

    }

    public void deleteAnswer(Answer answer) {

        User user = getMyUser();

        Answer a = answerRepository.findOne(answer.getId());

        Question question = a.getQuestion();


        if(user == a.getAnswerer()){
            question.getAnswers().remove(a);
            answerRepository.delete(a.getId());
        }

    }

    private QuestionDto convertToDto(Question q){

        List<Answer> answers = q.getAnswers();
        List<AnswerDto> answerDtos= new LinkedList<>();

        for(Answer a: answers){
            answerDtos.add(convertToDto(a));
        }

        QuestionDto dto = new QuestionDto(q.getId(), q.getTitle(), q.getText(), q.getDate(),
                convertToDto(q.getQuestioner()), q.isSolved(), answerDtos);

        return dto;
    }

    private AnswerDto convertToDto(Answer a) {
        return new AnswerDto(a.getId(), a.getText(), a.getDate(), convertToDto(a.getAnswerer()), a.isAccepted());
    }

    private UserDto convertToDto(User u){
        return new UserDto(u.getId(), u.getUsername());
    }

    public User getMyUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepository.findByUsername(name);
        return user;
    }
}
