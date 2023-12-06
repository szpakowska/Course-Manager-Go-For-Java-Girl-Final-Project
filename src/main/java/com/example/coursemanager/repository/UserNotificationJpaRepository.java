package com.example.coursemanager.repository;

import com.example.coursemanager.model.UserNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserNotificationJpaRepository extends JpaRepository<UserNotification, Long> {
}
