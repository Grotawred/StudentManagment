package com.example.StudentManagment.repository;

import com.example.StudentManagment.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
