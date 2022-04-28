package com.example.demo.controller;

import com.example.demo.aop.RestException;
import com.example.demo.domain.Storage;
import com.example.demo.domain.User;
import com.example.demo.service.SaveService;
import com.example.demo.service.UserService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
public class SaveController {
    private final SaveService saveService;
    private final UserService userService;

    @Autowired // 스프링 컨테이너가 멤버 서비스를 가져와줌
    public SaveController(SaveService saveService,UserService userService) {
        this.saveService = saveService;
        this.userService = userService;
    }

    @PostMapping("save")
    public User create(@RequestParam("id") String userId, @RequestParam("fav_repository") String favRepository, @RequestParam("branch") String branch) {
        parameterCheck(userId,favRepository,branch);

        User user = new User();
        user.setId(userId);
        user.setFav_repository(favRepository+"/branches/"+branch);
        Storage storage = new Storage();
        storage.setFav_repository(favRepository+"/branches/"+branch);
        storage.setGit_api_address(getUrlParser(favRepository,branch,0));
        storage.setGit_updated_at(getUpdatedAt(storage.getGit_api_address(),0));
        OffsetDateTime utc = OffsetDateTime.now(ZoneOffset.UTC);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        user.setUser_get_date(fmt.format(utc));
        saveService.join(storage,user);
        return user; //스프링이 자동으로 JSON타입으로 반환해서 전달한다.*/
    }

    @GetMapping("search")
    public String search(@RequestParam("id") String userId, @RequestParam("fav_repository") String favRepository, @RequestParam("branch") String branch){
        parameterCheck(userId,favRepository,branch);
        User user = new User();
        user.setId(userId);
        user.setFav_repository(favRepository+"/branches/"+branch);
        Optional<User> info =  userService.search(user); // 유저 정보가 존재하는지 체크
        String result = getUpdatedAt(getUrlParser(favRepository,branch,1)+"?sha="+branch+"&since="+info.get().getUser_get_date(),1);
        if(!result.equals("[]")) userService.updateGetDate(user);
        return result;
    }

    public static void parameterCheck(String userId,String favRepository,String branch){
        if(" ".equals(userId)||"".equals(userId)||userId == null)  throw new RestException(HttpStatus.NOT_FOUND, "유저아이디 정보는 필수입니다");
        if(" ".equals(favRepository)||"".equals(favRepository)||favRepository == null)  throw new RestException(HttpStatus.NOT_FOUND, "레포지토리 정보는 필수입니다");
        if(" ".equals(branch)||"".equals(branch)||branch == null)  throw new RestException(HttpStatus.NOT_FOUND, "브랜치 정보는 필수입니다");
    }

    public static String getUrlParser(String fav_repository,String branch,int mode){
        int index = fav_repository.indexOf("github");
        String url = fav_repository.substring(index);
        index = url.indexOf("/");

        url = "https://api.github.com/repos"+url.substring(index);
        if(mode==0) url += "/branches/"+branch;
        else url += "/commits";
        return url;
    }

    public static String getUpdatedAt(String url,int mode){
        String mono = WebClient.create().get()
            .uri(url)
            //.header("Authorization", "token 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")
            .retrieve()
            .onStatus(HttpStatus::is4xxClientError, response -> {
                throw new RestException(HttpStatus.NOT_FOUND, "레포지토리 혹은 브랜치 정보가 이상합니다");
             })
            .onStatus(HttpStatus::is5xxServerError, response -> {
                throw new RestException(HttpStatus.NOT_FOUND, "레포지토리 혹은 브랜치 정보가 이상합니다");
            })
            .bodyToMono(String.class)
            .block();
        if(mode==1) return mono;

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
