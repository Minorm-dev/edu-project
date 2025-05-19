package com.minorm.eduproject.database.repository;

import com.minorm.eduproject.database.entity.Course;
import com.minorm.eduproject.database.entity.CourseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByStatus(CourseStatus status);

    @Query("SELECT c FROM Course c WHERE c.teacher.id = :teacherId")
    List<Course> findByTeacherId(@Param("teacherId") Long teacherId);

    // Регистр учитывается!
    @Query("SELECT c FROM Course c WHERE LOWER(c.title) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Course> searchByTitle(@Param("query") String query);
}
