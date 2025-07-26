package com.example.demo.common.mapper;

import com.example.demo.common.dto.StandardDomainDto;
import com.example.demo.common.entity.StandardDomain;
import org.springframework.stereotype.Component;

@Component
public class StandardDomainMapper {
    public StandardDomainDto toDto(StandardDomain entity) {
        return StandardDomainDto.builder()
                .domainId(entity.getDomainId())
                .version(entity.getVersion())
                .groupName(entity.getGroupName())
                .categoryName(entity.getCategoryName())
                .domainName(entity.getDomainName())
                .description(entity.getDescription())
                .dataType(entity.getDataType())
                .dataLength(entity.getDataLength())
                .dataScale(entity.getDataScale())
                .storageFormat(entity.getStorageFormat())
                .displayFormat(entity.getDisplayFormat())
                .unit(entity.getUnit())
                .allowedValues(entity.getAllowedValues())
                .build();
    }

    public StandardDomain toEntity(StandardDomainDto dto) {
        return StandardDomain.builder()
                .version(dto.getVersion())
                .groupName(dto.getGroupName())
                .categoryName(dto.getCategoryName())
                .domainName(dto.getDomainName())
                .description(dto.getDescription())
                .dataType(dto.getDataType())
                .dataLength(dto.getDataLength())
                .dataScale(dto.getDataScale())
                .storageFormat(dto.getStorageFormat())
                .displayFormat(dto.getDisplayFormat())
                .unit(dto.getUnit())
                .allowedValues(dto.getAllowedValues())
                .build();
    }
}
