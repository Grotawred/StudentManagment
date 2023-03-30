package com.example.StudentManagment.validator;

import com.example.StudentManagment.entities.Student;
import com.example.StudentManagment.exceptions.NameNotAllowedException;
import org.springframework.stereotype.Component;

@Component
public class ValidateNotAllowedWords implements Validator{

    @Override
    public void execute(Student student) {
        if(student.getFirstName().equals("lox")
                || student.getLastName().equals("lox")
                || student.getEmail().equals("lox")){
            throw new NameNotAllowedException("NotAllowedName");
        }
    }
}
