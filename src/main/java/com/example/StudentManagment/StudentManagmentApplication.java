package com.example.StudentManagment;

import com.example.StudentManagment.entities.Student;
import com.example.StudentManagment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagmentApplication.class, args);
	}
}
