package com.example.StudentManagment.repository;

import com.example.StudentManagment.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
