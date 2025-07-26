package com.example.demo.common.controller;

import com.example.demo.common.dto.StandardTermDto;
import com.example.demo.common.service.StandardTermService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/standard/terms")
@RequiredArgsConstructor
@Tag(name = "표준 용어 API", description = "Standard Term 관리 API")
public class StandardTermController {
    private final StandardTermService service;

    @GetMapping
    @Operation(summary = "용어 전체 조회")
    public ResponseEntity<List<StandardTermDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "용어 단건 조회")
    public ResponseEntity<StandardTermDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    @Operation(summary = "용어 등록")
    public ResponseEntity<StandardTermDto> create(@RequestBody StandardTermDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "용어 수정")
    public ResponseEntity<StandardTermDto> update(@PathVariable Long id, @RequestBody StandardTermDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "용어 삭제")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
