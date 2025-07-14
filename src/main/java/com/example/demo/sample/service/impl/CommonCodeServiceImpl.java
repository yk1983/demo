package com.example.demo.sample.service.impl;

import com.example.demo.common.contants.UseYn;
import com.example.demo.sample.domain.dto.CommonCodeDetailDto;
import com.example.demo.sample.domain.dto.CommonCodeMasterDto;
import com.example.demo.sample.mapper.CommonCodeMapper;
import com.example.demo.sample.repository.CommonCodeDetailRepository;
import com.example.demo.sample.repository.CommonCodeMasterRepository;
import com.example.demo.sample.service.CommonCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonCodeServiceImpl implements CommonCodeService {
    private final CommonCodeMasterRepository masterRepository;
    private final CommonCodeDetailRepository detailRepository;
    private final CommonCodeMapper mapper;

    @Override
    public List<CommonCodeMasterDto> getCommonCodeMasterList() {
        return masterRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public List<CommonCodeDetailDto> getCommonCodeDetailList(String groupCode) {
        return detailRepository.findByGroupCodeAndUseYnOrderBySortOrderAsc(groupCode, UseYn.USE.getCode())
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public CommonCodeDetailDto getCommonCodeDetail(String groupCode, String code) {
        return mapper.toDto(detailRepository.findByGroupCodeAndCodeAndUseYn(groupCode, code, UseYn.USE.getCode()));
    }
}
