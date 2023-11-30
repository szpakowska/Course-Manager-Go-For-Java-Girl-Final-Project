package com.example.coursemanager.service;

import com.example.coursemanager.model.User;
import com.example.coursemanager.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserJpaRepository userJpaRepository;

    public List<User> getUserList() {
        return userJpaRepository.findAll();
    }

    public void addUser(User user) {
       userJpaRepository.save(user);
    }
}
