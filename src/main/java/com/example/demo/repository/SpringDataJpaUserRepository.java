package com.example.demo.repository;

import com.example.demo.domain.Member;
import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaUserRepository extends JpaRepository<Member,Long>, MemberRepository {

}
