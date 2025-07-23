package com.example.demo.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "사용자 응답 DTO")
public class UserResponseDto {
    /** 사용자 고유 ID */
    @Schema(description = "사용자 고유 ID", example = "1")
    private Long userId;
    /** 이메일 주소 */
    @Schema(description = "이메일 주소", example = "user@example.com")
    private String email;
    /** 이름 */
    @Schema(description = "이름", example = "홍길동")
    private String name;
    /** 전화번호 */
    @Schema(description = "전화번호", example = "01012345678")
    private String phone;
    /** 성별 (M: 남성, F: 여성) */
    @Schema(description = "성별 (M: 남성, F: 여성)", example = "M")
    private String gender;
    /** 생년월일 (YYYYMMDD) */
    @Schema(description = "생년월일 (YYYYMMDD)", example = "19900101")
    private String birthDate;
    /** 계정 상태 */
    @Schema(description = "계정 상태", example = "A")
    private String status;
    /** 이메일 인증 여부 */
    @Schema(description = "이메일 인증 여부", example = "N")
    private String emailVerified;
    /** 최근 로그인 시각 */
    @Schema(description = "최근 로그인 시각", example = "2025-07-15T22:00:00")
    private String lastLoginAt;
}
