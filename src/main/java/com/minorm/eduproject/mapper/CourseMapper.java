package com.minorm.eduproject.mapper;

import com.minorm.eduproject.database.entity.Course;
import com.minorm.eduproject.database.entity.Lesson;
import com.minorm.eduproject.dto.CourseRequest;
import com.minorm.eduproject.dto.CourseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = LessonMapper.class)
public interface CourseMapper {

    @Mapping(target = "teacher", ignore = true)
    @Mapping(target = "lessons", ignore = true)
    @Mapping(target = "enrollments", ignore = true)
    Course fromRequest(CourseRequest request);

    @Mapping(target = "teacherName", source = "teacher.fullName")
    @Mapping(target = "lessons", source = "lessons")
    CourseResponse toResponse(Course course);

    default List<CourseResponse.LessonInfo> mapLessons(List<Lesson> lessons) {
        return lessons.stream()
                .map(lesson -> new CourseResponse.LessonInfo(
                        lesson.getId(),
                        lesson.getTitle()
                )).toList();
    }
}
