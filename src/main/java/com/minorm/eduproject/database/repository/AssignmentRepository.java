package com.minorm.eduproject.database.repository;

import com.minorm.eduproject.database.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    Optional<Assignment> findByLessonIdAndStudentId(Long lessonId, Long studentId);

    List<Assignment> findByLessonId(Long lessonId);

    @Query("SELECT AVG(a.grade) FROM Assignment a WHERE a.lesson.course.id = :courseId")
    Double getAverageGradeByCourseId(@Param("courseId") Long courseId);
}
