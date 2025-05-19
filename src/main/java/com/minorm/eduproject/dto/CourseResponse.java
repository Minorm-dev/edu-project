package com.minorm.eduproject.dto;

import com.minorm.eduproject.database.entity.CourseStatus;

import java.time.Instant;
import java.util.List;

public record CourseResponse(
        Long id,
        String title,
        String description,
        CourseStatus courseStatus,
        String teacherName,
        Instant createdAt,
        List<LessonInfo> lessons
) {
    public record LessonInfo(
            Long id,
            String title
    ) {}
}
