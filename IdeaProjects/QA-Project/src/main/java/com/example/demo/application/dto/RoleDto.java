package com.example.demo.application.dto;

/**
 * A class for generating a DTO-object for the entity 'role'.
 * The generated object houses all necessary attributtes of an role-object
 * and provides getter- and setter-methodes for this attributes.
 */
public class RoleDto {

    private String name;

    /**
     * A constructor for a RoleDto-object.
     *
     * @param name tho name of the converted role.
     */
    public RoleDto(String name) {
        this.name = name;
    }


    /*
     * All setter- and getter-methodes needed to manage all attributes.
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
