package com.example.demo;

import com.example.demo.repository.*;
import com.example.demo.service.StorageService;
import com.example.demo.service.UserService;
import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final UserRepository userRepository;
    private final StorageRepository storageRepository;

    public SpringConfig(UserRepository userRepository, StorageRepository storageRepository) {
        this.userRepository = userRepository;
        this.storageRepository = storageRepository;
    }

    /*public SpringConfig(MemberRepository memberRepository,UserRepository userRepository) {
        this.memberRepository = memberRepository;
        this.userRepository = userRepository;
    }*/


    @Bean
    public UserService userService(){
        return new UserService(userRepository);
    }

    @Bean
    public StorageService StorageService(){
        return new StorageService(storageRepository);
    }

}
