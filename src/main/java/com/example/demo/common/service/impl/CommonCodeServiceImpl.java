package com.example.demo.common.service.impl;

import com.example.demo.common.entity.CommonCodeMaster;
import com.example.demo.global.contants.ErrorCode;
import com.example.demo.global.contants.UseYn;
import com.example.demo.common.dto.CommonCodeDetailDto;
import com.example.demo.common.dto.CommonCodeMasterDto;
import com.example.demo.common.mapper.CommonCodeMapper;
import com.example.demo.global.error.exception.BusinessException;
import com.example.demo.common.repository.CommonCodeDetailRepository;
import com.example.demo.common.repository.CommonCodeMasterRepository;
import com.example.demo.common.service.CommonCodeService;
import com.example.demo.global.error.exception.CustomNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonCodeServiceImpl implements CommonCodeService {
    private final CommonCodeMasterRepository masterRepository;
    private final CommonCodeDetailRepository detailRepository;
    private final CommonCodeMapper mapper;

    /**
     * @see CommonCodeService#getCommonCodeMasterList() 
     * @return List<CommonCodeMasterDto> 공통코드 마스터 목록
     */
    @Override
    public List<CommonCodeMasterDto> getCommonCodeMasterList() {
        return masterRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * @see CommonCodeService#createCommonCodeMaster(CommonCodeMasterDto) 
     * @param requestDto 공통코드 마스터 요청 DTO
     * @return CommonCodeMasterDto
     */
    @Override
    public CommonCodeMasterDto createCommonCodeMaster(CommonCodeMasterDto requestDto) {
        if (masterRepository.existsByGroupCode(requestDto.getGroupCode())) {
            throw new BusinessException(ErrorCode.DUPLICATED_CODE); // 이미 존재하는 코드입니다.
        }
        CommonCodeMaster entity = mapper.toEntity(requestDto);
        return mapper.toDto(masterRepository.save(entity));
    }

    /**
     * @see CommonCodeService#updateCommonCodeMaster(String, CommonCodeMasterDto)
     * @param groupCode 그룹코드
     * @param requestDto 공통코드 마스터 요청 DTO
     * @return CommonCodeMasterDto
     */
    @Override
    public CommonCodeMasterDto updateCommonCodeMaster(String groupCode, CommonCodeMasterDto requestDto) {
        CommonCodeMaster entity = masterRepository
                .findById(groupCode)
                .orElseThrow(() -> new CustomNotFoundException("해당 코드를 찾을 수 없습니다."));
        entity.setGroupName(requestDto.getGroupName());     // 그룹명칭
        entity.setDescription(requestDto.getDescription()); // 설명
        entity.setUseYn(requestDto.getUseYn());             // 사용여부
        entity.setSortOrder(requestDto.getSortOrder());     // 정렬순서
        return mapper.toDto(masterRepository.save(entity));
    }

    /**
     * @see CommonCodeService#getCommonCodeDetailList(String)
     * @param groupCode 그룹코드
     * @return List<CommonCodeDetailDto> 공통코드 상세 목록
     */
    public List<CommonCodeDetailDto> getCommonCodeDetailList(String groupCode) {
        return detailRepository.findByGroupCodeAndUseYnOrderBySortOrderAsc(groupCode, UseYn.USE.getCode())
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /**
     * @see CommonCodeService#getCommonCodeDetail(String, String)
     * @param groupCode 그룹코드
     * @param code 상세코드
     * @return CommonCodeDetailDto 공통코드 상세 단일 레코드
     */
    @Override
    public CommonCodeDetailDto getCommonCodeDetail(String groupCode, String code) {
        return mapper.toDto(detailRepository.findByGroupCodeAndCodeAndUseYn(groupCode, code, UseYn.USE.getCode()));
    }
}
