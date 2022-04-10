package com.example.demo.exception;

public class RepositoryNotFoundException extends BaseException {
    private static final long serialVersionUID = 1L;
    public RepositoryNotFoundException(String message){
        super(message);
    }
}
