package com.example.demo.common.mapper;

import com.example.demo.common.dto.CommonCodeDetailDto;
import com.example.demo.common.dto.CommonCodeMasterDto;
import com.example.demo.common.entity.CommonCodeDetail;
import com.example.demo.common.entity.CommonCodeMaster;
import org.springframework.stereotype.Component;

@Component
public class CommonCodeMapper {
    public CommonCodeMasterDto toDto(CommonCodeMaster entity) {
        return CommonCodeMasterDto.builder()
                .groupCode(entity.getGroupCode())
                .groupName(entity.getGroupName())
                .description(entity.getDescription())
                .useYn(entity.getUseYn())
                .sortOrder(entity.getSortOrder())
                .build();
    }

    public CommonCodeDetailDto toDto(CommonCodeDetail entity) {
        return CommonCodeDetailDto.builder()
                .groupCode(entity.getGroupCode())
                .code(entity.getCode())
                .codeName(entity.getCodeName())
                .attribute1(entity.getAttribute1())
                .attribute2(entity.getAttribute2())
                .attribute3(entity.getAttribute3())
                .attribute4(entity.getAttribute4())
                .attribute5(entity.getAttribute5())
                .useYn(entity.getUseYn())
                .sortOrder(entity.getSortOrder())
                .build();
    }

    public CommonCodeMaster toEntity(CommonCodeMasterDto dto) {
        return CommonCodeMaster.builder()
                .groupCode(dto.getGroupCode())
                .groupName(dto.getGroupName())
                .description(dto.getDescription())
                .useYn(dto.getUseYn())
                .sortOrder(dto.getSortOrder())
                .build();
    }

    public CommonCodeDetail toEntity(CommonCodeDetailDto dto) {
        return CommonCodeDetail.builder()
                .groupCode(dto.getGroupCode())
                .code(dto.getCode())
                .codeName(dto.getCodeName())
                .attribute1(dto.getAttribute1())
                .attribute2(dto.getAttribute2())
                .attribute3(dto.getAttribute3())
                .attribute4(dto.getAttribute4())
                .attribute5(dto.getAttribute5())
                .useYn(dto.getUseYn())
                .sortOrder(dto.getSortOrder())
                .build();
    }
}
