package com.example.coursemanager.repository;

import com.example.coursemanager.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseJpaRepository extends JpaRepository<Course, Long> {

    @Query("SELECT DISTINCT c FROM Course c " +
            "LEFT JOIN c.students s " +
            "WHERE s.id = :userId OR " +
            "c.id IN (SELECT cr.id FROM Course cr JOIN cr.blocks b WHERE b.lecturer.id = :userId)")
    List<Course> findCoursesByUserId(@Param("userId") Long userId);
}


