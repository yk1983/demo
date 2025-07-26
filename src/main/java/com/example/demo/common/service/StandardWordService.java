package com.example.demo.common.service;

import com.example.demo.common.dto.StandardWordDto;

import java.util.List;

public interface StandardWordService {
    List<StandardWordDto> findAll();

    StandardWordDto findById(Long id);

    StandardWordDto save(StandardWordDto dto);

    StandardWordDto update(Long id, StandardWordDto dto);

    void delete(Long id);
}
