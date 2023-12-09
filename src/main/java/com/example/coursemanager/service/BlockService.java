package com.example.coursemanager.service;

import com.example.coursemanager.repository.BlockJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlockService {
    private final BlockJpaRepository blockJpaRepository;

    public void deleteBlock(Long id) {
        blockJpaRepository.deleteById(id);
    }
}
