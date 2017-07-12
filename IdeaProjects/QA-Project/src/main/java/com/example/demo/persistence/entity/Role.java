package com.example.demo.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * A class for generating the entity role.
 * The generated object houses all necessary attributtes of an role-object
 * and provides getter- and setter-methodes for this attributes.
 */
@Entity
public class Role {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private Set<User> users;

    /**
     * A standard constructor for a Role-object.
     */
    public Role() {

    }

    /**
     * A constructor for a Role-object.
     *
     * @param name the name of the role.
     */
    public Role(String name) {
        this.name = name;
    }


    /*
     * All setter- and getter-methodes needed to manage all attributes.
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUser(User user) {this.users.add(user);}

}