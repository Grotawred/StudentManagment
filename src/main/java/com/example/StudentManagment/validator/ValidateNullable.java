package com.example.StudentManagment.validator;

import com.example.StudentManagment.entities.Student;
import com.example.StudentManagment.exceptions.ObjectNullException;
import org.springframework.stereotype.Component;

@Component
public class ValidateNullable implements Validator{
    @Override
    public void execute(Student student) {
        if(student.getFirstName()=="" || student.getLastName()=="" || student.getEmail()==""){
            throw new ObjectNullException("StudentNull");
        }
    }
}
