package com.minorm.eduproject.dto;

import java.time.Instant;

public record LessonResponse(
        Long id,
        String title,
        String content,
        String videoUrl,
        Long courseId,
        Instant createdAt
) {
}
