package com.example.demo.persistence.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * A class for generating the entity user.
 * The generated object houses all necessary attributtes of an user-object
 * and provides getter- and setter-methodes for this attributes.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    /**
     * A standard-constructor for an Answer-object.
     */
    public User() {
    }

    /**
     * A constructor for an User-object.
     *
     * @param username the username of the user.
     * @param password the password of the user.
     * @param roles the roles of the user.
     */
    public User(String username, String password, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setRole(Role role) {
        this.roles.add(role);
    }
}
