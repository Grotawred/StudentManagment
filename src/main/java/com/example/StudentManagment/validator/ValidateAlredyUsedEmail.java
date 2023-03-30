package com.example.StudentManagment.validator;

import com.example.StudentManagment.entities.Student;
import com.example.StudentManagment.exceptions.AlereadyUsedEmailException;
import com.example.StudentManagment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
@Component
public class ValidateAlredyUsedEmail implements Validator{
    @Autowired
    private StudentService studentService;
    @Override
    public void execute(Student student) {
        String studentEmail = student.getEmail();
        List<Student> students = studentService.getAllStudents();
        long count = students.stream()
                .map(x -> x.getEmail())
                .filter(email -> email.contains(studentEmail))
                .count();
        if(count>0){
            throw new AlereadyUsedEmailException("EmailAlreadyUsed");
        }
    }
}
