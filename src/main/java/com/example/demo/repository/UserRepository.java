package com.example.demo.repository;

import com.example.demo.domain.User;
        import com.example.demo.domain.UserKey;
        import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UserKey> {

}
