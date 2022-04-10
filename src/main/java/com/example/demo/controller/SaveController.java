package com.example.demo.controller;

import com.example.demo.domain.Storage;
import com.example.demo.domain.User;
import com.example.demo.exception.RepositoryNotFoundException;
import com.example.demo.service.SaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaveController {
    private final SaveService saveService;

    @Autowired // 스프링 컨테이너가 멤버 서비스를 가져와줌
    public SaveController(SaveService saveService) {
        this.saveService = saveService;
    }

    @PostMapping("/save")
    public User create(@RequestParam("id") String userId, @RequestParam("fav_repository") String favRepository, @RequestParam("branch") String branch) throws Exception {
        User user = new User();
        Storage storage = new Storage();
        saveService.join(storage,user);
        throw new RepositoryNotFoundException("test");
        //return user; //스프링이 자동으로 JSON타입으로 반환해서 전달한다.*/
    }
}
