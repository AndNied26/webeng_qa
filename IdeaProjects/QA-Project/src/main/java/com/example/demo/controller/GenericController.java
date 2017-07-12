package com.example.demo.controller;

import com.example.demo.persistence.repository.AnswerRepository;
import com.example.demo.persistence.repository.QuestionRepository;
import com.example.demo.persistence.repository.RoleRepository;
import com.example.demo.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenericController {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private boolean toggledInit = false;

    @Autowired
    public GenericController(QuestionRepository questionRepository, AnswerRepository answerRepository, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(value = "/deleteInit")
    public String deleteInit() {
        if (toggledInit == false) {
            this.questionRepository.deleteAll();
            this.answerRepository.deleteAll();
            this.userRepository.deleteAll();
            toggledInit = true;
            return "Sucessfull deleted! Please refresh QA site!";
        } else {
            return "Error! You already deleted the init data!";
        }

    }

}
