package com.smartinventory.product_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductDto {
    @NotBlank
    private String name;

    @NotBlank
    private String sku;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal price;

    private String description;

    @NotNull
    @JsonProperty("category_id")
    private Long categoryId;

    @NotNull
    @JsonProperty("supplier_id")
    private Long supplierId;

//    public static CreateProductDto fromEntity(Product product) {
//        return CreateProductDto.builder()
//                .name(product.getName())
//                .sku(product.getSku())
//                .price(product.getPrice())
//                .description(product.getDescription())
//                .categoryId(product.getCategory().getId())
//                .supplierId(product.getSupplier().getId())
//                .build();
//    }
}
