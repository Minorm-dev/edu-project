package com.minorm.eduproject.dto;

import java.time.Instant;
import java.time.LocalDateTime;

public record ReviewResponse(
        Long id,
        Integer rating,
        String comment,
        String studentName,
        Instant createdAt
) {
}
