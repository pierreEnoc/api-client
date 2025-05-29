package com.client.api.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscriptionTypeDto {

    private Long id;
    @NotBlank(message = "cannot be blank")
    @Size(min = 5, max = 30, message = "cannot exceed 30 characters")
    private String name;

    @Max(value = 12, message = "Access month cannot exceed 12")
    private Long accessMonth;

    @NotNull(message = "Price cannot be null")
    private BigDecimal price;

    @NotBlank(message = "Product key cannot be blank")
    @Size(min = 5, max = 15, message = "Price must be between 5 and 15 digits")
    private String productKey;
}
