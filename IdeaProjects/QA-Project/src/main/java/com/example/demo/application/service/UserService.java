package com.example.demo.application.service;

import com.example.demo.application.dto.UserDto;
import com.example.demo.application.exception.AccountFoundException;
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

/**
 * A class containing the methodes, which performs the action the user wanted to be done.
 */
@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * A constructor, which sets the local repositories to the actual repositories
     * and the local passwordEncoder to the actual passwordEncoder.
     *
     * @param userRepository the userRepository.
     * @param roleRepository the roleRepository.
     * @param passwordEncoder the passwordEncoder.
     */
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Adds the given user to the userRepository, if the given user is not already contained.
     *
     * @param user the given user.
     */
    public void addUser(User user) throws AccountFoundException{
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

        } else {
            throw new AccountFoundException();
        }
    }

    /**
     * a getter-method, for all users known by the application.
     *
     * @return a list of users.
     */
    public List<UserDto> getUsers() {
        List<User> allUsers = new LinkedList<>();
        userRepository.findAll().forEach(allUsers :: add);
        List<UserDto> dtos = new LinkedList<>();
        for(User u: allUsers){
            UserDto dto = convertToDto(u);
            dtos.add(dto);
        }
        return dtos;
    }

    /**
     * a getter-method, for the currently logged in user.
     *
     * @return the currently logged in user.
     */
    public UserDto getMyUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepository.findByUsername(name);
        UserDto dto = convertToDto(user);
        return dto;
    }
    
    private UserDto convertToDto(User u){
        return new UserDto(u.getId(), u.getUsername());
    }
}
