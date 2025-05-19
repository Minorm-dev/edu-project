package com.minorm.eduproject.dto;

import com.minorm.eduproject.database.entity.CourseStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CourseRequest(
        @NotBlank @Size(max = 255) String title,
        @Size(max = 1000) String description,
        @NotNull CourseStatus status
        ) {
}
