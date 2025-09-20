package com.smartinventory.product_service.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.smartinventory.product_service.dto.CreateProductDto;
import com.smartinventory.product_service.dto.UpdateProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(
        name = "products",
        indexes = {
                @Index(name = "idx_category_id", columnList = "category_id"),
                @Index(name = "idx_supplier_id", columnList = "supplier_id")
        }
)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 50, nullable = false)
    private String name;

    @Column(unique = true, length = 200, nullable = false)
    private String sku;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id", nullable = false)
    @JsonBackReference
    private Supplier supplier;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public static Product fromDto(CreateProductDto dto) {
        return Product.builder()
                .name(dto.getName())
                .sku(dto.getSku())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .build();
    }

    public void updateWithDto(UpdateProductDto dto) {
        if (dto.getName() != null)
            name = dto.getName();

        if (dto.getSku() != null)
            sku = dto.getSku();

        if (dto.getPrice() != null)
            price = dto.getPrice();

        if (dto.getDescription() != null)
            description = dto.getDescription();
    }
}

