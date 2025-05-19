package com.minorm.eduproject.mapper;

import com.minorm.eduproject.database.entity.Assignment;
import com.minorm.eduproject.dto.AssignmentRequest;
import com.minorm.eduproject.dto.AssignmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssignmentMapper {

    @Mapping(target = "student", ignore = true)
    @Mapping(target = "lesson", ignore = true)
    Assignment fromRequest(AssignmentRequest request);

    @Mapping(target = "studentName", expression = "java(assignment.getStudent().getFullName())")
    @Mapping(target = "lessonTitle", source = "lesson.title")
    AssignmentResponse toResponse(Assignment assignment);
}
