package com.smartinventory.product_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smartinventory.product_service.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponseDto {
    private Long id;
    private String name;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;


    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    public static CategoryResponseDto fromEntity(Category category) {
        return CategoryResponseDto.builder()
                .id(category.getId())
                .name(category.getName())
                .createdAt(category.getCreatedAt())
                .updatedAt(category.getUpdatedAt())
                .build();
    }
}
