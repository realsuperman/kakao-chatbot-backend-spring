package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void Insert() {
        User user = new User();
        user.setId("tjdgns461");
        user.setFav_repository("test");

        userRepository.save(user); // Insert
    }

    @Test
    public void get(){
        userRepository.findAll();
    }
}
