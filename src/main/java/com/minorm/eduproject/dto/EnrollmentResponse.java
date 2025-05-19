package com.minorm.eduproject.dto;

import java.time.Instant;

public record EnrollmentResponse(
        Long id,
        String studentName,
        String courseTitle,
        Instant enrollmentDate
) {
}
