package com.example.demo.application.dto;

import com.example.demo.persistence.entity.Role;

import java.util.Set;

public class UserDto {


    private Long id;

    private String username;

    public UserDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
