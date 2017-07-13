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

import java.util.HashSet;

/**
 * A class which inserts some user-objects and role-objects in the repository by starting the application.
 */
@Component
public class DBInit implements CommandLineRunner {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private boolean toggledInit = false;

    /**
     * A constructor wirering the local repositories to the actual repositories and the local passwordEncoder
     * to the actual passwordEncoder.
     *
     * @param userRepository the userRepositoty.
     * @param roleRepository the roleRepository.
     * @param passwordEncoder the passwordEncoder.
     */
    @Autowired
    public DBInit (QuestionRepository questionRepository, AnswerRepository answerRepository, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run (String... strings) {

    }



}
