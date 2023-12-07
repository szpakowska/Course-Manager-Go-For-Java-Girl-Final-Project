package com.example.coursemanager.service;

import com.example.coursemanager.model.Block;
import com.example.coursemanager.model.User;
import com.example.coursemanager.repository.BlockJpaRepository;
import com.example.coursemanager.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlockLecturerService {

    private final BlockJpaRepository blockJpaRepository;

    private final UserJpaRepository userJpaRepository;

    public void addLecturerToBlock(Long blockId, Long lecturerId) {
        Block block = blockJpaRepository.findById(blockId).orElseThrow(RuntimeException::new);
        User lecturer = userJpaRepository.findById(lecturerId).orElseThrow(RuntimeException::new);

        block.setLecturer(lecturer);
        blockJpaRepository.save(block);
    }

    public void removeLecturerFromBlock(Long blockId, Long lecturerId) {
        Block block = blockJpaRepository.findById(blockId).orElseThrow(RuntimeException::new);

        block.setLecturer(null);
        blockJpaRepository.save(block);
    }

}
