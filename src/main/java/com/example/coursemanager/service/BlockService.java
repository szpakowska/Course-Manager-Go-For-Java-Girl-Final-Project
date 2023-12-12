package com.example.coursemanager.service;

import com.example.coursemanager.model.Block;
import com.example.coursemanager.repository.BlockJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlockService {
    private final BlockJpaRepository blockJpaRepository;

    public void deleteBlock(Long id) {
        blockJpaRepository.deleteById(id);
    }

    public Block getBlockById(Long id) {
        return blockJpaRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Block> getAllBlocks() {return blockJpaRepository.findAll();


    }
}
