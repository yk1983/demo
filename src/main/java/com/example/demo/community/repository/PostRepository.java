package com.example.demo.community.repository;

import com.example.demo.community.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Board, Long> {

}
