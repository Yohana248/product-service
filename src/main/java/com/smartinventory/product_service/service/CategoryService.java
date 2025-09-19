package com.smartinventory.product_service.service;

import com.smartinventory.product_service.dto.CategoryResponseDto;
import com.smartinventory.product_service.dto.CategoryRequestDto;
import com.smartinventory.product_service.entity.Category;
import com.smartinventory.product_service.exception.ResourceNotFoundException;
import com.smartinventory.product_service.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryResponseDto> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    public CategoryResponseDto findById(Long id) throws ChangeSetPersister.NotFoundException {
        return categoryRepository.findById(id)
                .map(CategoryResponseDto::fromEntity)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    public CategoryResponseDto create(CategoryRequestDto dto) {
        return CategoryResponseDto.fromEntity(categoryRepository.save(Category.fromDto(dto)));
    }

    public CategoryResponseDto update(Long id, CategoryRequestDto dto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        category.setName(dto.getName());

        Category saved = categoryRepository.save(category);
        return CategoryResponseDto.fromEntity(saved);
    }

    public void delete(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Category not found with id " + id);
        }
        categoryRepository.deleteById(id);
    }
}
