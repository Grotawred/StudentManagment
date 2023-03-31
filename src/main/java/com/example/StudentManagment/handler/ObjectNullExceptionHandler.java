package com.example.StudentManagment.handler;

import com.example.StudentManagment.exceptions.ObjectNullException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ObjectNullExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ObjectNullException.class)
    public ModelAndView handleNameNotValidException(ObjectNullException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage", ex.getMessage());
        modelAndView.setViewName("errorPage");
        return modelAndView;
    }
}
