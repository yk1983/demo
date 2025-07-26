package com.example.demo.common.mapper;

import com.example.demo.common.dto.StandardWordDto;
import com.example.demo.common.entity.StandardWord;
import org.springframework.stereotype.Component;

@Component
public class StandardWordMapper {
    public StandardWordDto toDto(StandardWord entity) {
        return StandardWordDto.builder()
                .wordId(entity.getWordId())
                .version(entity.getVersion())
                .wordName(entity.getWordName())
                .wordAbbr(entity.getWordAbbr())
                .wordEng(entity.getWordEng())
                .description(entity.getDescription())
                .formatWordYn(entity.getFormatWordYn())
                .domainCategoryName(entity.getDomainCategoryName())
                .synonyms(entity.getSynonyms())
                .forbiddenWords(entity.getForbiddenWords())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public StandardWord toEntity(StandardWordDto dto) {
        return StandardWord.builder()
                .wordId(dto.getWordId())
                .version(dto.getVersion())
                .wordName(dto.getWordName())
                .wordAbbr(dto.getWordAbbr())
                .wordEng(dto.getWordEng())
                .description(dto.getDescription())
                .formatWordYn(dto.getFormatWordYn())
                .domainCategoryName(dto.getDomainCategoryName())
                .synonyms(dto.getSynonyms())
                .forbiddenWords(dto.getForbiddenWords())
                .build();
    }
}
