package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * A class for setting up a repository for storing user-entities.
 */

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
