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
            "JOIN c.blocks b " +
            "JOIN b.classes cl " +
            "WHERE :userId MEMBER OF c.students OR cl.lecturer = :userId")
    List<Course> findCoursesByLecturerId(@Param("userId") Long userId);
}


