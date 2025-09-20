package com.smartinventory.product_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smartinventory.product_service.entity.Product;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductDto {
    private String name;
    private String sku;

    @DecimalMin("0.0")
    private BigDecimal price;

    private String description;

    @JsonProperty("category_id")
    private Long categoryId;

    @JsonProperty("supplier_id")
    private Long supplierId;
}
