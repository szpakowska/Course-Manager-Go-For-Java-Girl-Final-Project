package com.example.coursemanager.repository;

import com.example.coursemanager.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleJpaRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);

}
