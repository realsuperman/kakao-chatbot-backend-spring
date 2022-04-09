package com.example.demo.service;

import com.example.demo.controller.RestException;
import com.example.demo.domain.Storage;
import com.example.demo.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SaveService {
    private final UserService userService;
    private final StorageService storageService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public SaveService(UserService userService, StorageService storageService) {
        this.userService = userService;
        this.storageService = storageService;
    }

    public void join(Storage storage, User user){
        throw new RestException(HttpStatus.NOT_FOUND, "Not found user");
        //userService.join(user);
        //storageService.join(storage);
    }
}
