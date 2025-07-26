package com.example.demo.common.mapper;

import com.example.demo.common.dto.StandardTermDto;
import com.example.demo.common.entity.StandardTerm;
import org.springframework.stereotype.Component;

@Component
public class StandardTermMapper {
    public StandardTermDto toDto(StandardTerm standardTerm) {
        return StandardTermDto.builder()
                .termId(standardTerm.getTermId())
                .version(standardTerm.getVersion())
                .termName(standardTerm.getTermName())
                .description(standardTerm.getDescription())
                .termAbbr(standardTerm.getTermAbbr())
                .domainName(standardTerm.getDomainName())
                .allowedValues(standardTerm.getAllowedValues())
                .storageFormat(standardTerm.getStorageFormat())
                .displayFormat(standardTerm.getDisplayFormat())
                .adminStdCodeName(standardTerm.getAdminStdCodeName())
                .organization(standardTerm.getOrganization())
                .synonyms(standardTerm.getSynonyms())
                .build();
    }

    public StandardTerm toEntity(StandardTermDto standardTermDto) {
        return StandardTerm.builder()
                .termId(standardTermDto.getTermId())
                .version(standardTermDto.getVersion())
                .termName(standardTermDto.getTermName())
                .description(standardTermDto.getDescription())
                .termAbbr(standardTermDto.getTermAbbr())
                .domainName(standardTermDto.getDomainName())
                .allowedValues(standardTermDto.getAllowedValues())
                .storageFormat(standardTermDto.getStorageFormat())
                .displayFormat(standardTermDto.getDisplayFormat())
                .adminStdCodeName(standardTermDto.getAdminStdCodeName())
                .organization(standardTermDto.getOrganization())
                .synonyms(standardTermDto.getSynonyms())
                .build();
    }
}
