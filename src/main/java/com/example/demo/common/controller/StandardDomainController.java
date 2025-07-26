package com.example.demo.common.controller;

import com.example.demo.common.service.StandardDomainService;
import com.example.demo.common.dto.StandardDomainDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/standard/domains")
@RequiredArgsConstructor
@Tag(name = "표준 도메인 API", description = "Standard Domain 관리 API")
public class StandardDomainController {
    private final StandardDomainService service;

    @GetMapping
    public ResponseEntity<List<StandardDomainDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardDomainDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<StandardDomainDto> create(@RequestBody StandardDomainDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
