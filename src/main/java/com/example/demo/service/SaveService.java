package com.example.demo.service;

import com.example.demo.domain.Storage;
import com.example.demo.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClientRequest;

import java.net.URI;
import java.time.Duration;

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
        /* 컨트롤러에서 완성해서 값을 날려준다 치고 storage의 git_api_address정보를 가지고 깃허브 api를 호출한다*/
        logger.info(storage.getGit_api_address());

        //System.out.println(webClient);
        /*userService.join(user);
        storageService.join(storage);*/

    }

    /*public User findByIdAndPassword(String id, String pw) {
        return WebClient()
                .get()
                .uri(String.format(URI.FIND_NO_BY_ID_PW.get(), new Object[] {id, encryptParam(pw)}))
                .exchange()
                .flatMap(res -> {
                    if (res.statusCode().value() == HttpStatus.NOT_FOUND.value()) {
                        return Mono.empty();
                    }
                    return res.bodyToMono(User.class);
                })
                .block();
    }*/



}

