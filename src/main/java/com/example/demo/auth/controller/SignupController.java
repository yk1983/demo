package com.example.demo.auth.controller;

import com.example.demo.global.response.BaseResponse;
import com.example.demo.auth.dto.SignupRequestDto;
import com.example.demo.auth.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Tag(name = "회원 권한 API", description = "회원 권한 관련 API")
public class SignupController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<BaseResponse<?>> signup(@Valid @RequestBody SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
        return ResponseEntity.ok().body(BaseResponse.success());
    }
}
