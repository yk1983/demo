package com.example.demo.common.service.impl;

import com.example.demo.common.dto.StandardTermDto;
import com.example.demo.common.entity.StandardTerm;
import com.example.demo.common.mapper.StandardTermMapper;
import com.example.demo.common.repository.StandardTermRepository;
import com.example.demo.common.service.StandardTermService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StandardTermServiceImpl implements StandardTermService {
    private final StandardTermRepository repository;
    private final StandardTermMapper mapper;

    public List<StandardTermDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public StandardTermDto findById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow();
    }

    public StandardTermDto create(StandardTermDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public StandardTermDto update(Long id, StandardTermDto dto) {
        StandardTerm entity = repository.findById(id).orElseThrow();
        dto.setTermId(id);
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
