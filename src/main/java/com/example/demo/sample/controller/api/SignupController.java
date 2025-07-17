package com.example.demo.sample.controller.api;

import com.example.demo.common.response.BaseResponse;
import com.example.demo.sample.domain.dto.SignupRequestDto;
import com.example.demo.sample.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SignupController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<BaseResponse<?>> signup(@Valid @RequestBody SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
        return ResponseEntity.ok().body(BaseResponse.success());
    }
}
