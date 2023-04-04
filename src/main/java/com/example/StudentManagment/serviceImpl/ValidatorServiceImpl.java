package com.example.StudentManagment.serviceImpl;

import com.example.StudentManagment.entities.Student;
import com.example.StudentManagment.service.ValidatorService;
import com.example.StudentManagment.validator.ValidateAlredyUsedEmail;
import com.example.StudentManagment.validator.ValidateNotAllowedWords;
import com.example.StudentManagment.validator.ValidateNullable;
import com.example.StudentManagment.validator.Validator;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
@Service
public class ValidatorServiceImpl implements ValidatorService {
    private final LinkedList<Validator> validators = new LinkedList<>();
    public ValidatorServiceImpl(ValidateNullable validateNullable, ValidateNotAllowedWords validateNotAllowedWords, ValidateAlredyUsedEmail validateAlredyUsedEmail){
        validators.add(validateNullable);
        validators.add(validateNotAllowedWords);
        validators.add(validateAlredyUsedEmail);
    }
    @Override
    public void executeAll(Student student) {
        validators.forEach(validator -> validator.execute(student));
    }
}
