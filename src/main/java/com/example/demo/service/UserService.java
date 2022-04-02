package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.domain.User;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.StorageRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String join(User user){
        userRepository.save(user);
        return user.getId();
    }

}
