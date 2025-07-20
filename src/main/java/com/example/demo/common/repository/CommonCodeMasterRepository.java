package com.example.demo.common.repository;

import com.example.demo.common.entity.CommonCodeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonCodeMasterRepository extends JpaRepository<CommonCodeMaster, String> {
    boolean existsByGroupCode(String groupCode);
}
