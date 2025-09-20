package com.smartinventory.product_service.service;

import com.smartinventory.product_service.dto.CreateProductDto;
import com.smartinventory.product_service.dto.PagedResponse;
import com.smartinventory.product_service.dto.ProductResponseDto;
import com.smartinventory.product_service.dto.UpdateProductDto;
import com.smartinventory.product_service.entity.Category;
import com.smartinventory.product_service.entity.Product;
import com.smartinventory.product_service.entity.Supplier;
import com.smartinventory.product_service.exception.ResourceNotFoundException;
import com.smartinventory.product_service.repository.CategoryRepository;
import com.smartinventory.product_service.repository.ProductRepository;
import com.smartinventory.product_service.repository.SupplierRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    public List<ProductResponseDto> findAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    public PagedResponse<ProductResponseDto> findByCategoryAndPriceRange(
            Long categoryId, BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable
    ) {
        Page<ProductResponseDto> page = productRepository
                .findByCategoryIdAndPriceBetween(categoryId, minPrice, maxPrice, pageable)
                .map(ProductResponseDto::fromEntity);

        return new PagedResponse<>(
                page.getContent(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isLast()
        );
    }


    public ProductResponseDto findById(Long id) {
        return productRepository.findById(id)
                .map(ProductResponseDto::fromEntity)
                .orElse(null);
    }

    public ProductResponseDto create(CreateProductDto dto) {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        Supplier supplier = supplierRepository.findById(dto.getSupplierId())
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));

        Product product = Product.fromDto(dto);
        product.setCategory(category);
        product.setSupplier(supplier);

        Product saved = productRepository.save(product);
        return ProductResponseDto.fromEntity(saved);
    }

    public ProductResponseDto update(Long id, UpdateProductDto dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        product.updateWithDto(dto);

        return ProductResponseDto.fromEntity(productRepository.save(product));
    }

    public void delete(Long id) {
        if (!productRepository.existsById(id))
            throw new ResourceNotFoundException("Product not found");

        productRepository.deleteById(id);
    }
}