package com.example.demo.application.service;

import com.example.demo.persistence.entity.Answer;
import com.example.demo.persistence.entity.Question;
import com.example.demo.persistence.entity.Role;
import com.example.demo.persistence.entity.User;
import com.example.demo.persistence.repository.AnswerRepository;
import com.example.demo.persistence.repository.QuestionRepository;
import com.example.demo.persistence.repository.RoleRepository;
import com.example.demo.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;


/**
 * A class containing the methods, which performs the action the user wanted to be done.
 */
@Service
public class GenericService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private boolean toggledInit = false;

    /**
     * A constructor, which sets the local repositories to the actual repositories
     * and the local passwordEncoder to the actual passwordEncoder.
     *
     * @param questionRepository the questionRepository
     * @param answerRepository the answerRepository
     * @param userRepository the userRepository
     * @param roleRepository the roleRepository
     * @param passwordEncoder the passwordEncoder
     */
    @Autowired
    public GenericService(QuestionRepository questionRepository, AnswerRepository answerRepository, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Adds some users and some questions to the already running application, if possible.
     * This task can only be performed once!
     *
     * @return a String-value, which contains a messege accoring to, if the initialization was successful or not.
     */
    public String addInit() {
        if(!toggledInit) {
            if(userRepository.findAll().isEmpty()) {
                addUsers();
                addQuestions();
                return "Please refresh QA site!";
            } else {
                return "Error! You already added data yourself.";
            }
        } else {
            return "Error! You already added the init data!";
        }
    }

    /**
     * Adds some users with their password and their roles to the database.
     */
    public void addUsers() {
        Role role = new Role();
        role.setName("USER");
        roleRepository.save(role);

        HashSet<Role> userRoles = new HashSet<>();
        userRoles.add(role);


        User user1 = new User();
        user1.setUsername("Max");
        user1.setPassword(passwordEncoder.encode("passMax"));
        user1.setRoles(userRoles);
        userRepository.save(user1);


        User user2 = new User();
        user2.setUsername("Karl");
        user2.setPassword(passwordEncoder.encode("passKarl"));
        user2.setRoles(userRoles);
        userRepository.save(user2);
    }

    /**
     * Adds some questions with the already given answers to the database.
     */
    public void addQuestions() {
        Question question1 = new Question("How to code Hello World", "Hello, how can i code Hello World in Brainfuck?", userRepository.findByUsername("Max"));
        questionRepository.save(question1);
        Answer answertoquestion1 = new Answer("Hello, ++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>. This should work", userRepository.findByUsername("Karl"), question1);
        answerRepository.save(answertoquestion1);
        question1.addAnswer(answertoquestion1);
        questionRepository.save(question1);

        Question question2 = new Question("Programming Languages", "Hello, i'm searching programming languages like Brainfuck.", userRepository.findByUsername("Karl"));
        questionRepository.save(question2);
        Answer answer1toquestion2 = new Answer("Check out Boolfuck!", userRepository.findByUsername("Max"), question2);
        Answer answer2toquestion2 = new Answer ("Binodu, Blub, Befunge etc. Have a look at esolangs.org ;)", userRepository.findByUsername("Max"), question2);
        answerRepository.save(answer1toquestion2);
        answerRepository.save(answer2toquestion2);
        question2.addAnswer(answer1toquestion2);
        question2.addAnswer(answer2toquestion2);
        questionRepository.save(question2);
    }
}

