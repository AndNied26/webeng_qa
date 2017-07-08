package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
