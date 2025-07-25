package com.example.demo.member.repository;

import com.example.demo.global.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<User,Long> {
    List<User> findByUsernameOrName(String email, String name);
}
