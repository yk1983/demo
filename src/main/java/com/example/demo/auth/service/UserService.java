package com.example.demo.auth.service;

import com.example.demo.auth.dto.SignupRequestDto;

public interface UserService {
    void registerUser(SignupRequestDto requestDto);
}
