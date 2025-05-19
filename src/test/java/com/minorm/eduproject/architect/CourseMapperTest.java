package com.minorm.eduproject.architect;

import com.minorm.eduproject.database.entity.Course;
import com.minorm.eduproject.database.entity.CourseStatus;
import com.minorm.eduproject.database.entity.User;
import com.minorm.eduproject.dto.CourseResponse;
import com.minorm.eduproject.mapper.CourseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CourseMapperTest {

    @Autowired
    private CourseMapper courseMapper;

    @Test
    void shouldMapCourseToResponse() {
        User teacher = User.builder()
                .firstName("John")
                .lastName("Doe")
                .build();

        Course course = Course.builder()
                .title("Java Basics")
                .description("Intro to Java")
                .status(CourseStatus.PUBLISHED)
                .teacher(teacher)
                .build();

        CourseResponse response = courseMapper.toResponse(course);

        assertThat(response.teacherName()).isEqualTo("John Doe");
        assertThat(response.title()).isEqualTo("Java Basics");
    }
}
