package com.example.coursemanager.repository;

import com.example.coursemanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    Optional<User> findById(Long id);

//    @Modifying
//    @Query("UPDATE User u SET u.surname = :surname WHERE u.id = :id")
//    void updateSurname(@Param("id") Long id, @Param("surname") String surname);
//
//    @Modifying
//    @Query("UPDATE User u SET u.email = :email WHERE u.id = :id")
//    void updateEmail(@Param("id") Long id, @Param("email") String email);

}
