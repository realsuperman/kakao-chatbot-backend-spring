package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.domain.UserKey;
import com.example.demo.repository.UserRepository;

import java.util.Optional;

//@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String join(User user){
        userRepository.save(user);
        return user.getId();
    }

    public Optional<User> find(User user){
        UserKey userKey = new UserKey();
        userKey.setId(user.getId());
        userKey.setFav_repository(user.getFav_repository());
        return userRepository.findById(userKey);
    }

}
