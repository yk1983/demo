package com.example.demo.common.service.impl;

import com.example.demo.common.dto.StandardWordDto;
import com.example.demo.common.entity.StandardWord;
import com.example.demo.common.mapper.StandardWordMapper;
import com.example.demo.common.repository.StandardWordRepository;
import com.example.demo.common.service.StandardWordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StandardWordServiceImpl implements StandardWordService {
    private final StandardWordRepository repository;
    private final StandardWordMapper mapper;

    public List<StandardWordDto> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public StandardWordDto findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("표준단어를 찾을 수 없습니다."));
    }

    public StandardWordDto save(StandardWordDto dto) {
        StandardWord saved = repository.save(mapper.toEntity(dto));
        return mapper.toDto(saved);
    }

    public StandardWordDto update(Long id, StandardWordDto dto) {
        StandardWord entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("표준단어를 찾을 수 없습니다."));

        entity.setVersion(dto.getVersion());
        entity.setWordName(dto.getWordName());
        entity.setWordAbbr(dto.getWordAbbr());
        entity.setWordEng(dto.getWordEng());
        entity.setDescription(dto.getDescription());
        entity.setFormatWordYn(dto.getFormatWordYn());
        entity.setDomainCategoryName(dto.getDomainCategoryName());
        entity.setSynonyms(dto.getSynonyms());
        entity.setForbiddenWords(dto.getForbiddenWords());

        return mapper.toDto(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
