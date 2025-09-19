package com.smartinventory.product_service.service;

import com.smartinventory.product_service.dto.CreateSupplierDto;
import com.smartinventory.product_service.dto.SupplierResponseDto;
import com.smartinventory.product_service.dto.UpdateSupplierDto;
import com.smartinventory.product_service.entity.Supplier;
import com.smartinventory.product_service.exception.ResourceNotFoundException;
import com.smartinventory.product_service.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public List<SupplierResponseDto> findAll() {
        return supplierRepository.findAll()
                .stream()
                .map(SupplierResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    public SupplierResponseDto findById(Long id) {
        return supplierRepository.findById(id)
                .map(SupplierResponseDto::fromEntity)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
    }

    public SupplierResponseDto create(CreateSupplierDto dto) {
        Supplier saved = supplierRepository.save(Supplier.fromDto(dto));
        return SupplierResponseDto.fromEntity(saved);
    }

    public SupplierResponseDto update(Long id, UpdateSupplierDto dto) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));

        supplier.updateWithDto(dto);

        return SupplierResponseDto.fromEntity(supplierRepository.save(supplier));
    }

    public void delete(Long id) {
        if (!supplierRepository.existsById(id))
            throw new ResourceNotFoundException("Supplier not found");

        supplierRepository.deleteById(id);
    }
}
