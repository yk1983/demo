package com.example.demo.common.repository;

import com.example.demo.common.entity.CommonCodeDetail;
import com.example.demo.common.entity.CommonCodeDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonCodeDetailRepository extends JpaRepository<CommonCodeDetail, CommonCodeDetailId> {
    List<CommonCodeDetail> findByGroupCodeAndUseYnOrderBySortOrderAsc(String codeGroup, String useYn);

    CommonCodeDetail findByGroupCodeAndCodeAndUseYn(String groupCode, String code, String useYn);
}
