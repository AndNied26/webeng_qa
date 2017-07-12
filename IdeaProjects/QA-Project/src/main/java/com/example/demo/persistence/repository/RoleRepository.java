package com.example.demo.persistence.repository;


import com.example.demo.persistence.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * A class for setting up a repository for storing role-entities.
 */

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query(value = "select r from Role r where r.name = :rolename")
    Role findByRoleName(@Param("rolename") String rolename);
}
