package com.example.coursemanager.repository;

import com.example.coursemanager.model.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockJpaRepository extends JpaRepository<Block, Long> {
}


