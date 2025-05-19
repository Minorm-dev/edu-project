package com.minorm.eduproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LessonRequest(
        @NotBlank @Size(max = 255) String title,
        @Size(max = 5000) String content,
        String videoUrl
) {
}
