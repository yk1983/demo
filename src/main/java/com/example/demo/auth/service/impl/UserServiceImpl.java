package com.example.demo.auth.service.impl;

import com.example.demo.global.util.MessageUtil;
import com.example.demo.auth.dto.SignupRequestDto;
import com.example.demo.auth.mapper.UserMapper;
import com.example.demo.auth.repository.UserRepository;
import com.example.demo.auth.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(@Valid SignupRequestDto requestDto) {
        if (userRepository.existsByUsername(requestDto.getEmail())) {
            throw new IllegalArgumentException(MessageUtil.getMessage("error.email.duplicate"));
        }

        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword())); // 비밀번호 암호화
        userRepository.save(UserMapper.toEntity(requestDto));
    }
}
