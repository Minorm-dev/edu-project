package com.minorm.eduproject.mapper;

import com.minorm.eduproject.database.entity.Lesson;
import com.minorm.eduproject.dto.LessonRequest;
import com.minorm.eduproject.dto.LessonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    @Mapping(target = "course", ignore = true)
    @Mapping(target = "assignments", ignore = true)
    Lesson fromRequest(LessonRequest request);

    @Mapping(target = "courseId", source = "course.id")
    LessonResponse toResponse(Lesson lesson);

    List<LessonResponse> toResponseList(List<Lesson> lessons);
}
