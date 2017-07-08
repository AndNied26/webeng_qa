package com.example.demo.application.service;

import com.example.demo.persistence.entity.Role;
import com.example.demo.persistence.entity.User;
import com.example.demo.persistence.repository.RoleRepository;
import com.example.demo.persistence.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(User user) {
        if(userRepository.findByUsername(user.getUsername()) == null) {

            Role role;

            if(roleRepository.findByRoleName("USER") == null){
                role = new Role("USER");
                roleRepository.save(role);
            }else {
                role = roleRepository.findByRoleName("USER");
            }

            HashSet<Role> roles = new HashSet<>();
            roles.add(role);
            User newUser = user;
            newUser.setPassword(passwordEncoder.encode(user.getPassword()));
            newUser.setRoles(roles);


            userRepository.save(newUser);
        }
    }

    public List<User> getUsers() {
        List<User> allUsers = new LinkedList<>();
        userRepository.findAll().forEach(allUsers :: add);
        return allUsers;
    }


    public User getMyUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepository.findByUsername(name);
        return user;
    }


}
