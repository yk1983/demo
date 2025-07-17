package com.example.demo.sample.service;

import com.example.demo.sample.domain.dto.SignupRequestDto;

public interface UserService {
    void registerUser(SignupRequestDto requestDto);
}
