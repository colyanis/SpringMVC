package com.mykola.spring.web.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by mtverdok on 4/28/2017.
 */

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(NullPointerException.class)
    public String handle(NullPointerException ex) {
        ex.printStackTrace();
        return "error";
    }
}
