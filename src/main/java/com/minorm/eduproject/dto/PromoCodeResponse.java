package com.minorm.eduproject.dto;

import com.minorm.eduproject.database.entity.DiscountType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PromoCodeResponse(
        Long id,
        String code,
        DiscountType discountType,
        BigDecimal discountValue,
        LocalDateTime validFrom,
        LocalDateTime validTo
//        Integer remainingUsages
) {
}
