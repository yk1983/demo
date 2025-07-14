package com.example.demo.sample.repository;

import com.example.demo.sample.domain.entity.CommonCodeDetail;
import com.example.demo.sample.domain.entity.CommonCodeDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonCodeDetailRepository extends JpaRepository<CommonCodeDetail, CommonCodeDetailId> {
    List<CommonCodeDetail> findByGroupCodeAndUseYnOrderBySortOrderAsc(String codeGroup, String useYn);

    CommonCodeDetail findByGroupCodeAndCodeAndUseYn(String groupCode, String code, String useYn);
}
