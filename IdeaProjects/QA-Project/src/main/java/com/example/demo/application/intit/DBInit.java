package com.example.demo.application.intit;


import com.example.demo.persistence.entity.Answer;
import com.example.demo.persistence.entity.Question;
import com.example.demo.persistence.entity.Role;
import com.example.demo.persistence.entity.User;
import com.example.demo.persistence.repository.AnswerRepository;
import com.example.demo.persistence.repository.QuestionRepository;
import com.example.demo.persistence.repository.RoleRepository;
import com.example.demo.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;

@Component
public class DBInit implements CommandLineRunner {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private boolean toggledInit = false;

    @Autowired
    public DBInit (QuestionRepository questionRepository, AnswerRepository answerRepository, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run (String... strings) throws Exception {
        Role role = new Role();
        role.setName("USER");
        roleRepository.save(role);

        HashSet<Role> userRoles = new HashSet<>();
        userRoles.add(role);


        User user1 = new User();
        user1.setUsername("Max");
        user1.setPassword(passwordEncoder.encode("hallo"));
        user1.setRoles(userRoles);
        userRepository.save(user1);


        User user2 = new User();
        user2.setUsername("Karl");
        user2.setPassword(passwordEncoder.encode("1234"));
        user2.setRoles(userRoles);
        userRepository.save(user2);

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
