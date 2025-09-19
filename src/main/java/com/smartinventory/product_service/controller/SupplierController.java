package com.smartinventory.product_service.controller;

import com.smartinventory.product_service.dto.CreateSupplierDto;
import com.smartinventory.product_service.dto.SupplierResponseDto;
import com.smartinventory.product_service.dto.UpdateSupplierDto;
import com.smartinventory.product_service.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/suppliers")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public ResponseEntity<List<SupplierResponseDto>> findAll() {
        return ResponseEntity.ok(supplierService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(supplierService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SupplierResponseDto> create(@Valid @RequestBody CreateSupplierDto dto) {
        SupplierResponseDto created = supplierService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateSupplierDto dto
    ) {
        return ResponseEntity.ok(supplierService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        supplierService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
