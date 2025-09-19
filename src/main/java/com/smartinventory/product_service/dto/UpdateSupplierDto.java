package com.smartinventory.product_service.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UpdateSupplierDto {
    @Length(max = 50)
    private String name;

    @Length(max = 100)
    @Email(message = "Not valid email format")
    private String email;

    @Length(max = 20)
    private String phone;

    private String address;
}
