package com.example.demo.controller;

import com.example.demo.domain.Storage;
import com.example.demo.domain.User;
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
        user.setId(userId);
        user.setFav_repository(favRepository+"/branches"+branch);
        Storage storage = new Storage();
        storage.setFav_repository(favRepository+"/branches"+branch);
        getUrlParser(favRepository,branch);
        saveService.join(storage,user);
        return user; //스프링이 자동으로 JSON타입으로 반환해서 전달한다.*/
    }

    public static String getUrlParser(String fav_repository,String branch){

        /* url : https://github.com/realsuperman/spring-project
           branch : master
         */
        /*index = fav_repository.find('github')
        url = fav_repository[index:]
        index = url.find("/")
        url = "https://api.github.com/repos"+url[index:]+"/branches/"+branch*/
        return null;
    }

}
