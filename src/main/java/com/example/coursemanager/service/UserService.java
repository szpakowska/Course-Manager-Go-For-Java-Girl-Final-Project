package com.example.coursemanager.service;

import com.example.coursemanager.dto.UserDto;
import com.example.coursemanager.model.User;
import com.example.coursemanager.repository.UserJpaRepository;
import com.example.coursemanager.utils.mapper.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserJpaRepository userJpaRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> getUserList() {
        return userJpaRepository.findAll();
    }

    public User getUserById(Long id) {
        return userJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }


    public UserDto addUser(UserDto userDto) {
        User user = UserMapper.toUserModel(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User addUser = userJpaRepository.save(user);
        return UserMapper.toUserDto(addUser);
    }

    public User updateUser(UserDto userDto, Long id) {
        User dbUser = getUserById(id);
        dbUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        dbUser.setUsername(userDto.getUsername());
        dbUser.setEmail(userDto.getEmail());
        dbUser.setName(userDto.getName());
        dbUser.setSurname(userDto.getSurname());
        dbUser.setActive(userDto.getActive());
        dbUser.setRoles(userDto.getRoles());
        return userJpaRepository.save(dbUser);
    }

    public void deleteUser(Long id) {
        boolean isUser = userJpaRepository.existsById(id);
        if (!isUser) {
            throw new EntityNotFoundException("User not found" + id);
        }
        userJpaRepository.deleteById(id);
    }
}
