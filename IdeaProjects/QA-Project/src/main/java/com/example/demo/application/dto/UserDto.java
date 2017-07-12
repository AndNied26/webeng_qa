package com.example.demo.application.dto;

/**
 * A class for generating a DTO-object for the entity 'user'.
 * The generated object houses all necessary attributtes of an user-object
 * and provides getter- and setter-methodes for this attributes.
 */
public class UserDto {

    private Long id;

    private String username;

    /**
     * A constructor for a UserDto-object.
     *
     * @param id the id of the converted user.
     * @param username the username of the converted user.
     */
    public UserDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }


    /*
     * All setter- and getter-methodes needed to manage all attributes.
     */
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
