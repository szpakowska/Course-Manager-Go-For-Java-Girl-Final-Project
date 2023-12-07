package com.example.coursemanager.service;

import com.example.coursemanager.model.Block;
import com.example.coursemanager.model.Course;
import com.example.coursemanager.repository.CourseJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseBlocksService {

    private final CourseJpaRepository courseJpaRepository;


    public void addBlockToCourse(Long courseId, String blockName) {
        Block block = new Block(blockName);
        Course course = courseJpaRepository.findById(courseId).orElseThrow(RuntimeException::new);
        if (course.getBlocks() == null) {
            course.setBlocks(new HashSet<>(List.of(block)));
        } else {
            course.getBlocks().add(block);
        }

        courseJpaRepository.save(course);
    }

    public void removeBlockFromCourse(Long courseId, Long blockId) {
        Course course = courseJpaRepository.findById(courseId).orElseThrow(RuntimeException::new);

        Optional.ofNullable(course.getBlocks())
                .orElseThrow(RuntimeException::new)
                .removeIf(block -> block.getId().equals(blockId));

        courseJpaRepository.save(course);
    }

}
