package com.example.demo.service;

import com.example.demo.domain.Storage;
import com.example.demo.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SaveService {
    private final UserService userService;
    private final StorageService storageService;

    public SaveService(UserService userService, StorageService storageService) {
        this.userService = userService;
        this.storageService = storageService;
    }

    public void join(Storage storage, User user){
        userService.join(user);
        storageService.join(storage);
    }
}
