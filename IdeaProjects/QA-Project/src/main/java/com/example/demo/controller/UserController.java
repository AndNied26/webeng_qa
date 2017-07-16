package com.example.demo.controller;

import com.example.demo.application.exception.AccountFoundException;
import com.example.demo.application.service.UserService;
import com.example.demo.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A class mapping the URLs to the methods of the service-classes.
 */
@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * A constructor, which sets the local questionService to the actual questionService.
     *
     * @param userService the userService.
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Adds the given user to the userRepository.
     * path: localhost:8080/addUser , type: POST
     *
     * @param user the given user.
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody User user) throws AccountFoundException {
        userService.addUser(user);
    }

    /**
     * A getter-method, for all users the application knows.
     * path: localhost:8080/getAllUsers , type: GET
     *
     * @return a list of user-objects.
     */
    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public List<User> getUsers(){return userService.getUsers();}


    /**
     * A getter-method, for the currently logged in user.
     * path: localhost:8080/getMxUser , type: GET
     *
     * @return the currently logged in user.
     */
    @RequestMapping(value = "/getMyUser", method = RequestMethod.GET)
    public User getMyUser() {return userService.getMyUser();}

}
