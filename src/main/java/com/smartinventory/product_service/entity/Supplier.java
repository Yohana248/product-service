package com.smartinventory.product_service.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.smartinventory.product_service.dto.CreateSupplierDto;
import com.smartinventory.product_service.dto.UpdateSupplierDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "suppliers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100)
    private String email;

    @Column(length = 20)
    private String phone;

    private String address;

    @OneToMany(mappedBy = "supplier")
    @JsonManagedReference
    private List<Product> products = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public static Supplier fromDto(CreateSupplierDto dto) {
        return Supplier.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .address(dto.getAddress())
                .build();
    }

    public void updateWithDto(UpdateSupplierDto dto) {
        name = dto.getName() != null ? dto.getName() : name;
        email = dto.getEmail() != null ? dto.getEmail() : email;
        phone = dto.getPhone() != null ? dto.getPhone() : phone;
        address = dto.getAddress() != null ? dto.getAddress() : address;
    }
}