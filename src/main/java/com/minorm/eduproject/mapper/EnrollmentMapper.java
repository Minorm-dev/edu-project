package com.minorm.eduproject.mapper;

import com.minorm.eduproject.database.entity.Enrollment;
import com.minorm.eduproject.dto.EnrollmentRequest;
import com.minorm.eduproject.dto.EnrollmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {

    @Mapping(target = "student", ignore = true)
    @Mapping(target = "course", ignore = true)
    Enrollment fromRequest(EnrollmentRequest request);

    @Mapping(target = "studentName", expression = "java(enrollment.getStudent().getFullName())")
    @Mapping(target = "courseTitle", source = "course.title")
    EnrollmentResponse toResponse(Enrollment enrollment);
}
