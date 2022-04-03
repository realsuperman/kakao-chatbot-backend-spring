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

    @Test
    void join() {
        User user = new User();
        Storage storage = new Storage();
        user.setId("tjdgns461");
        user.setFav_repository("test");
        storage.setFav_repository("test");
        storage.setGit_api_address("test");
        storage.setGit_updated_at("test");
        saveService.join(storage,user);
    }
}