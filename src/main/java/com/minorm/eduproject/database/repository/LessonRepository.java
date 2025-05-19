package com.minorm.eduproject.database.repository;

import com.minorm.eduproject.database.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findByCourseId(Long courseId);

    // проверка на существование урока в курсе
    boolean existsByCourseIdAndId(Long courseId, Long lessonId);
}
