package com.example.StudentManagment.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String password;
    @Column(name = "role", nullable = false, unique = true)
    private String role;
    @Column(name = "login", nullable = false, unique = true)
    private String login;
}
