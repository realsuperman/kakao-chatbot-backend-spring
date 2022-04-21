package com.example.demo.controller;

import com.example.demo.aop.RestException;
import com.example.demo.domain.Storage;
import com.example.demo.domain.User;
import com.example.demo.service.SaveService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@RestController
public class SaveController {
    private final SaveService saveService;

    @Autowired // 스프링 컨테이너가 멤버 서비스를 가져와줌
    public SaveController(SaveService saveService) {
        this.saveService = saveService;
    }

    @PostMapping("/save")
    public User create(@RequestParam("id") String userId, @RequestParam("fav_repository") String favRepository, @RequestParam("branch") String branch) {
        if(" ".equals(userId)||"".equals(userId)||userId == null)  throw new RestException(HttpStatus.NOT_FOUND, "유저아이디 정보는 필수입니다");
        if(" ".equals(favRepository)||"".equals(favRepository)||favRepository == null)  throw new RestException(HttpStatus.NOT_FOUND, "레포지토리 정보는 필수입니다");
        if(" ".equals(branch)||"".equals(branch)||branch == null)  throw new RestException(HttpStatus.NOT_FOUND, "브랜치 정보는 필수입니다");

        User user = new User();
        user.setId(userId);
        user.setFav_repository(favRepository+"/branches/"+branch);
        Storage storage = new Storage();
        storage.setFav_repository(favRepository+"/branches/"+branch);
        storage.setGit_api_address(getUrlParser(favRepository,branch));
        storage.setGit_updated_at(getUpdatedAt(storage.getGit_api_address()));
        OffsetDateTime utc = OffsetDateTime.now(ZoneOffset.UTC);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        user.setUser_get_date(fmt.format(utc));
        saveService.join(storage,user);
        return user; //스프링이 자동으로 JSON타입으로 반환해서 전달한다.*/
    }

    public static String getUrlParser(String fav_repository,String branch){
        int index = fav_repository.indexOf("github");
        String url = fav_repository.substring(index);
        index = url.indexOf("/");
        url = "https://api.github.com/repos"+url.substring(index)+"/branches/"+branch;
        return url;
    }

    public static String getUpdatedAt(String url){
        String mono = WebClient.create().get()
            .uri(url)
            .header("Authorization", "token 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")
            .retrieve()
            .onStatus(HttpStatus::is4xxClientError, response -> {
                throw new RestException(HttpStatus.NOT_FOUND, "레포지토리 혹은 브랜치 정보가 이상합니다");
             })
            .onStatus(HttpStatus::is5xxServerError, response -> {
                throw new RestException(HttpStatus.NOT_FOUND, "레포지토리 혹은 브랜치 정보가 이상합니다");
            })
            .bodyToMono(String.class)
            .block();
        JSONParser parser = new JSONParser();
        try {
            JSONObject elem = (JSONObject) parser.parse(mono);
            elem = (JSONObject) elem.get("commit");
            elem = (JSONObject) elem.get("commit");
            elem = (JSONObject) elem.get("committer");
            return elem.get("date").toString();
        } catch (ParseException e) {
            throw new RestException(HttpStatus.NOT_FOUND, "JSON 파싱 실패 오류.");
        }
    }
}
