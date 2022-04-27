package com.example.demo.service;

import com.example.demo.aop.RestException;
import com.example.demo.domain.User;
import com.example.demo.domain.UserKey;
import com.example.demo.repository.UserRepository;
import org.springframework.http.HttpStatus;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Transactional
public class UserService {
    private final UserRepository userRepository;
    //private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String join(User user){
        if(findUser(user).isPresent()) throw new RestException(HttpStatus.NOT_FOUND, "유저 정보가 존재합니다.");
        userRepository.save(user);
        return user.getId();
    }

    public Optional<User> findUser(User user){
        UserKey userKey = new UserKey();
        userKey.setId(user.getId());
        userKey.setFav_repository(user.getFav_repository());
        return userRepository.findById(userKey);
    }

    public Optional<User> search(User user) {
        Optional<User> returnUser = findUser(user);
        if(!returnUser.isPresent()) throw new RestException(HttpStatus.NOT_FOUND, "해당하는 유저 정보가 없습니다 ");
        return returnUser;
    }

    public void updateGetDate(User user){
        OffsetDateTime utc = OffsetDateTime.now(ZoneOffset.UTC);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        user.setUser_get_date(fmt.format(utc));
        try {
            userRepository.save(user);
        }catch(IllegalArgumentException e){
            throw new RestException(HttpStatus.NOT_FOUND, "정보를 저장하는데 오류가 생겼습니다");
        }
    }
}

