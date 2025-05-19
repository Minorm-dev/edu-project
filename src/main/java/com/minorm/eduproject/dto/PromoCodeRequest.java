package com.minorm.eduproject.dto;

import com.minorm.eduproject.database.entity.DiscountType;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PromoCodeRequest(
        @NotBlank @Size(max = 20) String code,
        @NotNull DiscountType discountType,
        @NotNull @DecimalMin("0.01")BigDecimal discountValue,
        @NotNull LocalDateTime validFrom,
        @NotNull LocalDateTime validTo,
        @NotNull @Min(1) Integer maxUsages
        ) {
}
