package com.example.demo.sample.repository;

import com.example.demo.sample.domain.entity.CommonCodeMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonCodeMasterRepository extends JpaRepository<CommonCodeMaster, String> {
}
