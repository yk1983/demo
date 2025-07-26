package com.example.demo.common.repository;

import com.example.demo.common.entity.StandardWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandardWordRepository extends JpaRepository<StandardWord, Long> {
}
