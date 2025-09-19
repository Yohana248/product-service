package com.smartinventory.product_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSupplierDto {
    @NotBlank
    @Length(max = 50)
    private String name;

    @Length(max = 100)
    @Email(message = "Not valid email format")
    private String email;

    @Length(max = 20)
    private String phone;

    private String address;
}
