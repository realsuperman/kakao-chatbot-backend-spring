package com.example.demo.service;

import com.example.demo.aop.RestException;
import com.example.demo.domain.Storage;
import com.example.demo.domain.User;
import org.springframework.http.HttpStatus;
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
        try{
            userService.join(user);
            storageService.join(storage);
        }catch(IllegalArgumentException e){
            throw new RestException(HttpStatus.NOT_FOUND, "정보를 저장하는데 실패하였습니다.");
        }

    }
}
