package com.example.coursemanager.utils.mapper;

import com.example.coursemanager.dto.UserDto;
import com.example.coursemanager.model.User;

public class UserMapper {
    public static User toUserModel(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setActive(userDto.getActive());
        user.setRoles(userDto.getRoles());
        user.setLessons(userDto.getLessons());
        user.setNotifications(userDto.getNotifications());
        return user;
    }

    public static UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setActive(user.getActive());
        userDto.setRoles(user.getRoles());
        userDto.setLessons(user.getLessons());
        userDto.setNotifications(user.getNotifications());
        return userDto;
    }

}
