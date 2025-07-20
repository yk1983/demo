package com.example.demo.common.service;

import com.example.demo.common.dto.CommonCodeDetailDto;
import com.example.demo.common.dto.CommonCodeMasterDto;
import jakarta.validation.Valid;

import java.util.List;

public interface CommonCodeService {
    /**
     * 공통코드 마스터 목록을 조회한다.
     * @return List<CommonCodeMasterDto> 공통코드 마스터 목록
     */
    List<CommonCodeMasterDto> getCommonCodeMasterList();

    /**
     * 공통코드 마스터를 등록한다.
     * @param requestDto 공통코드 마스터 요청 DTO
     * @return CommonCodeDetailDto
     */
    CommonCodeMasterDto createCommonCodeMaster(CommonCodeMasterDto requestDto);

    /**
     * 그룹코드에 해당하는 공통코드 마스터를 수정한다.
     * @param groupCode 그룹코드
     * @param requestDto 공통코드 마스터 요청 DTO
     * @return CommonCodeDetailDto
     */
    CommonCodeMasterDto updateCommonCodeMaster(String groupCode, CommonCodeMasterDto requestDto);

    /**
     * 공통코드 마스터 그룹코드로 상세코드 목록을 조회한다.
     * @param groupCode 그룹코드
     * @return List<CommonCodeDetailDto> 공통코드 상세 목록
     */
    List<CommonCodeDetailDto> getCommonCodeDetailList(String groupCode);

    /**
     * 공통코드 마스터 그룹코드와 상세코드로 상세코드 단일 레코드를 조회한다.
     * @param groupCode 그룹코드
     * @param detailCode 상세코드
     * @return CommonCodeDetailDto
     */
    CommonCodeDetailDto getCommonCodeDetail(String groupCode, String detailCode);
}
