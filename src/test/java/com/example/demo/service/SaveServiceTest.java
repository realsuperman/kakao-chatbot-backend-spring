package com.example.demo.service;

import com.example.demo.domain.Storage;
import com.example.demo.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
class SaveServiceTest {
    @Autowired
    SaveService saveService;
    @Autowired
    StorageService storageService;
    @Autowired
    UserService userService;

    @Test
    void join() {
        User user = new User();
        Storage storage = new Storage();
        /*user.setId("tjdgns461");
        user.setFav_repository("https://github.com/realsuperman/spring-project/branches/master");
        user.setUser_get_date("20200101");*/
        /*storage.setFav_repository("https://github.com/realsuperman/spring-project/branches/master");
        storage.setGit_api_address("https://api.github.com/repos/realsuperman/spring-project/branches/master");
        storage.setGit_updated_at("test");
        saveService.join(storage,user);*/
        userService.join(user);
    }
}