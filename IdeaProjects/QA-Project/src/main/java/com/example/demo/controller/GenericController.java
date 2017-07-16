package com.example.demo.controller;

import com.example.demo.application.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A class mapping the URLs to the methods of the service-classes.
 */
@RestController
public class GenericController {

    @Autowired
    private GenericService genericService;
    private boolean toggledInit = false;


    /**
     * A constructor, which sets the local genericService to the actual genericService.
     *
     * @param genericService the genericService.
     */
    public GenericController(GenericService genericService) {
        this.genericService = genericService;
    }

    /**
     * Adds some users and some questions to the already running application.
     * This task can only be performed once!
     *
     * @return a String-value, which contains a messege accoring to, if the initialization was successful or not
     */
    @RequestMapping(value = "/addInit")
    public String addInit() {
        return genericService.addInit();
    }
}
