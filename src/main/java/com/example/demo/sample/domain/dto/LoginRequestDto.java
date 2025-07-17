package com.example.demo.sample.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "로그인 DTO")
public class LoginRequestDto {
    /** 로그인 이메일 */
    @Email
    @NotBlank(message = "로그인 이메일은 필수입력입니다.")
    @Schema(description = "로그인 이메일")
    private String username;
    /** 로그인 비밀번호 */
    @NotBlank(message = "로그인 비밀번호는 필수입력입니다.")
    @Schema(description = "로그인 비밀번호")
    private String password;
}
