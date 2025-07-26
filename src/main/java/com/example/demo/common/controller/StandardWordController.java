package com.example.demo.common.controller;

import com.example.demo.common.dto.StandardWordDto;
import com.example.demo.common.service.StandardWordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/standard/words")
@RequiredArgsConstructor
@Tag(name = "표준 단어 API", description = "Standard Word 관리 API")
public class StandardWordController {
    private final StandardWordService service;

    @GetMapping
    public ResponseEntity<List<StandardWordDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardWordDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<StandardWordDto> create(@RequestBody StandardWordDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardWordDto> update(@PathVariable Long id, @RequestBody StandardWordDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
