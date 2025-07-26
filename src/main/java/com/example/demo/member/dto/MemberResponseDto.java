package com.example.demo.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "회원 응답 모델")
public class MemberResponseDto {
    /** 사용자 고유 ID */
    @Schema(description = "사용자 고유 ID", example = "1")
    private Long id;
    /** 사용자 이름 */
    @NotBlank
    @Schema(description = "사용자 이름", example = "홍길동")
    private String name;
    /** 사용자 이메일 */
    @NotBlank
    @Email
    @Schema(description = "사용자 이메일", example = "user@example.com")
    private String email;
    /** 전화번호 */
    @Schema(description = "전화번호", example = "01012345678")
    private String phone;
    /** 성별 (M: 남성, F: 여성) */
    @Schema(description = "성별 (M: 남성, F: 여성)", example = "M")
    private String gender;
    /** 생년월일 (YYYYMMDD) */
    @Schema(description = "생년월일 (YYYYMMDD)", example = "19900101")
    private String birthDate;
    /** 계정 생성일 */
    @Schema(description = "계정 생성일", example = "2025-07-16 09:00:00")
    private String createdAt;
}
