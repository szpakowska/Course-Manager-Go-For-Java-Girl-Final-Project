package com.example.coursemanager.service;

import com.example.coursemanager.dto.LessonDto;
import com.example.coursemanager.model.Block;
import com.example.coursemanager.model.Lesson;
import com.example.coursemanager.repository.BlockJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class BlockLessonService {

    private final BlockJpaRepository blockJpaRepository;

    public void addLessonToBlock(Long blockId, LessonDto lessonDto) {
        Block block = blockJpaRepository.findById(blockId).orElseThrow(RuntimeException::new);
        Lesson lesson = lessonDto.toLesson();

        if (block.getLessons() == null) {
            block.setLessons(new ArrayList<>(List.of(lesson)));
        }
        else {
            block.getLessons().add(lesson);
        }

        blockJpaRepository.save(block);
    }

    public void removeLessonFromBlock(Long blockId, Long lessonId) {
        Block block = blockJpaRepository.findById(blockId).orElseThrow(RuntimeException::new);
        Optional.ofNullable(block.getLessons()).orElseThrow(RuntimeException::new)
                .removeIf(lesson -> lesson.getId().equals(lessonId));

        blockJpaRepository.save(block);
    }
}
