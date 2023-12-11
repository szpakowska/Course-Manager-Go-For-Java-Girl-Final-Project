package com.example.coursemanager.repository;

import com.example.coursemanager.model.Lesson;
import com.example.coursemanager.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationJpaRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByLessons(Lesson lesson);

    Optional<Notification> findById(Long id);


    @Query("SELECT DISTINCT n FROM Notification n " +
            "JOIN n.lessons l " +
            "LEFT JOIN l.users u " +
            "WHERE u.id = :userId " +
            "ORDER BY n.isRead ASC")
    List<Notification> findNotificationsByUserIdAndSortByRead(Long userId);

}
