package com.example.demo.repository;

import com.example.demo.domain.Member;
        import com.example.demo.domain.User;
        import com.example.demo.domain.UserKey;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, UserKey> {

}
