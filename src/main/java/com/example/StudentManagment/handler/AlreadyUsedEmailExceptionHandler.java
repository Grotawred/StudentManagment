package com.example.StudentManagment.handler;

import com.example.StudentManagment.exceptions.AlereadyUsedEmailException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class AlreadyUsedEmailExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AlereadyUsedEmailException.class)
    public ModelAndView handleAlreadyUsedException(AlereadyUsedEmailException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage", ex.getMessage());
        modelAndView.setViewName("errorPage");
        return modelAndView;
    }
}
