package com.example.demo.common.service;

import com.example.demo.common.dto.StandardDomainDto;

import java.util.List;

public interface StandardDomainService {
    List<StandardDomainDto> findAll();

    StandardDomainDto findById(Long id);

    StandardDomainDto save(StandardDomainDto dto);

    void delete(Long id);
}
