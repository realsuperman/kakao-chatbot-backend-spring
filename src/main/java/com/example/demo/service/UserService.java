package com.example.demo.service;

import com.example.demo.aop.RestException;
import com.example.demo.domain.User;
import com.example.demo.domain.UserKey;
import com.example.demo.repository.UserRepository;
import org.springframework.http.HttpStatus;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String join(User user){
        if(checkUser(user).isPresent()) throw new RestException(HttpStatus.NOT_FOUND, "유저 정보가 존재합니다.");
        userRepository.save(user);
        return user.getId();
    }

    public Optional<User> checkUser(User user){
        UserKey userKey = new UserKey();
        userKey.setId(user.getId());
        userKey.setFav_repository(user.getFav_repository());
        return userRepository.findById(userKey);
    }
}

