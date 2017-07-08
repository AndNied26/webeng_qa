package com.example.demo.persistence.repository;


import com.example.demo.persistence.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    /*@Query(value = "select s from Student s where s.courses.size > :number")
    List<Student> getStudentsWithMoreCoursesThan(@Param("number") Integer number);*/

    @Query(value = "select r from Role r where r.name = :rolename")
    Role findByRoleName(@Param("rolename") String rolename);
}
