package com.example.demo.advice;

import com.example.demo.exception.BaseException;
import com.example.demo.exception.RepositoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.example.demo.controller")
public class GlobalExceptionHandler {
    @ExceptionHandler(value = RepositoryNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String methodArgumentNotValidException(BaseException e) {
        return e.getMessage();
    }
}
