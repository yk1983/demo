package com.example.demo.common.service.impl;

import com.example.demo.common.service.StandardDomainService;
import com.example.demo.common.dto.StandardDomainDto;
import com.example.demo.common.entity.StandardDomain;
import com.example.demo.common.mapper.StandardDomainMapper;
import com.example.demo.common.repository.StandardDomainRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StandardDomainServiceImpl implements StandardDomainService {
    private final StandardDomainRepository repository;
    private final StandardDomainMapper mapper;

    public List<StandardDomainDto> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public StandardDomainDto findById(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("도메인 정보 없음")));
    }

    public StandardDomainDto save(StandardDomainDto dto) {
        StandardDomain saved = repository.save(mapper.toEntity(dto));
        return mapper.toDto(saved);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
