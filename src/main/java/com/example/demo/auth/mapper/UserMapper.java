package com.example.demo.auth.mapper;

import com.example.demo.global.util.DateUtil;
import com.example.demo.auth.dto.SignupRequestDto;
import com.example.demo.auth.dto.UserResponseDto;
import com.example.demo.global.entity.User;

public class UserMapper {

    public static UserResponseDto toDto(User user) {
        if (user == null) return null;
        return UserResponseDto.builder()
                .userId(user.getUserId())
                .email(user.getUsername())
                .name(user.getName())
                .phone(user.getPhone())
                .gender(user.getGender())
                .birthDate(user.getBirthDate())
                .status(user.getStatus())
                .emailVerified(user.getEmailVerified())
                .lastLoginAt(user.getLastLoginAt() != null ? user.getLastLoginAt().toString() : null)
                .build();
    }

    public static User toEntity(SignupRequestDto userDto) {
        return User.builder()
                .username(userDto.getEmail())
                .password(userDto.getPassword())
                .name(userDto.getName())
                .phone(userDto.getPhone())
                .gender(userDto.getGender().getCode())
                .birthDate(DateUtil.format(userDto.getBirthDate()))
                .build();
    }
}
