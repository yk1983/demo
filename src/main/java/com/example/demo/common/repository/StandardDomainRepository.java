package com.example.demo.common.repository;

import com.example.demo.common.entity.StandardDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandardDomainRepository extends JpaRepository<StandardDomain, Long> {
}
