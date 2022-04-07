package com.example.demo.service;

import com.example.demo.domain.Storage;
import com.example.demo.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Transactional
public class SaveService {
    private final UserService userService;
    private final StorageService storageService;
    static final Logger LOGGER = LoggerFactory.getLogger(SaveService .class);

    public SaveService(UserService userService, StorageService storageService) {
        this.userService = userService;
        this.storageService = storageService;
    }

    public void join(Storage storage, User user){
        /* 컨트롤러에서 완성해서 값을 날려준다 치고 storage의 git_api_address정보를 가지고 깃허브 api를 호출한다*/
        WebClient webClient = WebClient
                .builder()
                .baseUrl(storage.getGit_api_address())
                .defaultHeader("Authorization", "token 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")
                .build();
        WebClient.ResponseSpec responseSpec = webClient.get()
                .retrieve();
        //System.out.println(webClient);
        /*userService.join(user);
        storageService.join(storage);*/

    }

}

