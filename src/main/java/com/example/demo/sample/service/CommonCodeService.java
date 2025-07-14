package com.example.demo.sample.service;

import com.example.demo.sample.domain.dto.CommonCodeDetailDto;
import com.example.demo.sample.domain.dto.CommonCodeMasterDto;

import java.util.List;

public interface CommonCodeService {

    List<CommonCodeMasterDto> getCommonCodeMasterList();

    List<CommonCodeDetailDto> getCommonCodeDetailList(String groupCode);

    CommonCodeDetailDto getCommonCodeDetail(String groupCode, String code);
}
