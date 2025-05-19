package com.minorm.eduproject.dto;

import java.time.LocalDateTime;

public record AssignmentResponse(
        Long id,
        String answer,
        Integer grade,
        String studentName,
        String lessonTitle,
        LocalDateTime submittedAt
) {
}
