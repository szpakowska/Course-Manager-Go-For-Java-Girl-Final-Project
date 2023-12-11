package com.example.coursemanager.service;

import com.example.coursemanager.dto.NotificationDto;
import com.example.coursemanager.model.Lesson;
import com.example.coursemanager.model.Notification;
import com.example.coursemanager.repository.LessonJpaRepository;
import com.example.coursemanager.repository.NotificationJpaRepository;
import com.example.coursemanager.utils.mapper.NotificationMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationJpaRepository notificationJpaRepository;
    private final LessonJpaRepository lessonJpaRepository;


    public List<Notification> getNotificationsForLesson(Long lessonId) {
        Optional<Lesson> lesson = lessonJpaRepository.findById(lessonId);

        if (lesson.isPresent()) {
            return notificationJpaRepository.findByLessons(lesson.get());
        } else {
            return Collections.emptyList();
        }
    }

    public Notification getNotificationById(Long id) {
        return notificationJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
    }

    public NotificationDto addNotification(NotificationDto notificationDto) {
        Notification notification = NotificationMapper.toNotificationModel(notificationDto);
        Notification addNotification = notificationJpaRepository.save(notification);
        return NotificationMapper.toNotificationDto(addNotification);
    }


    public Notification updateNotification(NotificationDto notificationDto, Long id) {
        Notification dbNotification = getNotificationById(id);
        dbNotification.setSubject(notificationDto.getSubject());
        dbNotification.setContent(notificationDto.getContent());
        dbNotification.setLessons(notificationDto.getLessons());
        return notificationJpaRepository.save(dbNotification);
    }

    public void deleteNotification(Long id) {
        boolean isNotification = notificationJpaRepository.existsById(id);
        if (!isNotification) {
            throw new EntityNotFoundException("Notification not found" + id);
        }
        notificationJpaRepository.deleteById(id);
    }

    public List<Notification> getAllNotications() {
        return notificationJpaRepository.findAll();
    }

    public List<Notification> getNotificationByUserId(Long userId) {
        return notificationJpaRepository.findNotificationsByUserIdAndSortByRead(userId);
    }
}
