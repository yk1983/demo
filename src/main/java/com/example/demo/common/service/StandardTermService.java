package com.example.demo.common.service;

import com.example.demo.common.dto.StandardTermDto;

import java.util.List;

public interface StandardTermService {
    List<StandardTermDto> findAll();

    StandardTermDto findById(Long id);

    StandardTermDto create(StandardTermDto dto);

    StandardTermDto update(Long id, StandardTermDto dto);

    void delete(Long id);
}
