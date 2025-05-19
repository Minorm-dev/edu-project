package com.minorm.eduproject.dto;

import com.minorm.eduproject.database.entity.RefundStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RefundResponse(
        Long id,
        BigDecimal amount,
        LocalDateTime refundDate,
        String reason,
        RefundStatus status
) {
}
