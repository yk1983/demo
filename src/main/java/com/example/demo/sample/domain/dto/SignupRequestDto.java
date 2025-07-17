package com.example.demo.sample.domain.dto;

import com.example.demo.common.contants.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "사용자 요청 DTO")
public class SignupRequestDto {
    /** 이메일 */
    @Email(message = "유효한 이메일 형식이어야 합니다.")
    @NotBlank(message = "{validation.email.required}")
    private String email;
    /** 비밀번호 */
    @NotBlank(message = "비밀번호는 필수 항목입니다.")
    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하로 입력하세요.")
    private String password;
    /** 이름 */
    @NotBlank(message = "이름은 필수 항목입니다.")
    private String name;
    /** 휴대전화번호 */
    @NotBlank(message = "전화번호는 필수 항목입니다.")
    @Pattern(regexp = "\\d{10,11}", message = "전화번호는 숫자만 10~11자리 입력하세요.")
    private String phone;

    @NotNull(message = "성별은 필수 항목입니다.")
    private Gender gender;

    @NotNull(message = "생년월일은 필수 항목입니다.")
    @Past(message = "생년월일은 과거 날짜여야 합니다.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
}
