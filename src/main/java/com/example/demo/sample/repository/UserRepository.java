package com.example.demo.sample.repository;

import com.example.demo.sample.domain.entity.User;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String email);

    boolean existsByUsername(@NotBlank String username);

}
