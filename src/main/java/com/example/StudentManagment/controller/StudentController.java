package com.example.StudentManagment.controller;

import com.example.StudentManagment.entities.Student;
import com.example.StudentManagment.service.StudentService;
import com.example.StudentManagment.validator.ValidateAlredyUsedEmail;
import com.example.StudentManagment.validator.ValidateNotAllowedWords;
import com.example.StudentManagment.validator.ValidateNullable;
import com.example.StudentManagment.validator.Validator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
public class StudentController {
    private final StudentService studentService;
    private final List<Validator> validators = new LinkedList<>();

    public StudentController(StudentService studentService, ValidateNullable validateNullabling, ValidateNotAllowedWords validateNotAllowedWords, ValidateAlredyUsedEmail validateAlredyUsedEmail) {
        validators.add(validateNullabling);
        validators.add(validateNotAllowedWords);
        validators.add(validateAlredyUsedEmail);
        this.studentService = studentService;
    }


    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentFrom(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        validators.forEach(x -> x.execute(student));
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/student/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello";
    }

}
