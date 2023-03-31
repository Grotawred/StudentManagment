package com.example.StudentManagment.handler;

import com.example.StudentManagment.exceptions.NameNotAllowedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class NameNotAllowedExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NameNotAllowedException.class)
    public ModelAndView handleNameNotAllowedException(NameNotAllowedException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage", ex.getMessage());
        modelAndView.setViewName("errorPage");
        return modelAndView;
    }
}
