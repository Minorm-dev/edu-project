package com.minorm.eduproject.dto;

import com.minorm.eduproject.database.entity.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PurchaseResponse(
        Long id,
        String courseTitle,
        BigDecimal amount,
        BigDecimal discountApplied,
        PaymentStatus status,
        LocalDateTime purchaseDate
) {
}
