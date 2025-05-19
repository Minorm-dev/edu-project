package com.minorm.eduproject.dto;

import jakarta.validation.constraints.NotNull;

public record EnrollmentRequest(
        @NotNull Long studentId,
        @NotNull Long courseId
) {
}
