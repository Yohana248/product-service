package com.smartinventory.product_service.controller;

import com.smartinventory.product_service.dto.CategoryResponseDto;
import com.smartinventory.product_service.dto.CategoryRequestDto;
import com.smartinventory.product_service.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
    @Autowired
    public CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> findOne(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDto> create(@Valid @RequestBody CategoryRequestDto request) {
        CategoryResponseDto created = categoryService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody CategoryRequestDto request) {
        CategoryResponseDto updated = categoryService.update(id, request);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
