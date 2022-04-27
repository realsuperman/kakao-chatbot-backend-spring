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

    /*public Optional<User> search(User user) {
        Optional<User> returnUser = userService.findUser(user);
        if(!returnUser.isPresent()) throw new RestException(HttpStatus.NOT_FOUND, "해당하는 유저 정보가 없습니다");
        /*Storage sto = new Storage();
        sto.setFav_repository(user.getFav_repository());
        Optional<Storage> storage = storageService.findRepository(sto);
        if(!storage.isPresent()) throw new RestException(HttpStatus.NOT_FOUND, "레포지토리 정보가 없습니다");
        returnUser.get().setGit_api_address(storage.get().getGit_api_address());
        return returnUser;
    }*/
}
