package com.example.demo.common.repository;

import com.example.demo.common.entity.StandardTerm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandardTermRepository extends JpaRepository<StandardTerm, Long> {
}
