package com.example.demo.global.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "사용자 정보 엔티티")
public class User implements UserDetails {
    /** 사용자 고유 ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @Schema(description = "사용자 고유 ID", example = "1")
    private Long userId;
    /** 사용자 이메일 */
    @Column(name = "email", length = 100, nullable = false, unique = true)
    @Schema(description = "사용자 이메일", example = "user@example.com")
    private String username;
    /** 비밀번호 (암호화) */
    @Column(name = "password", length = 256, nullable = false)
    @Schema(description = "비밀번호 (암호화)", example = "$2a$10$...")
    private String password;
    /** 사용자 이름 */
    @Column(length = 50, nullable = false)
    @Schema(description = "사용자 이름", example = "홍길동")
    private String name;
    /** 전화번호 */
    @Column(length = 20, nullable = false)
    @Schema(description = "전화번호", example = "01012345678")
    private String phone;
    /** 성별 (M: 남성, F: 여성) */
    @Column(length = 1, nullable = false)
    @Schema(description = "성별 (M: 남성, F: 여성)", example = "M")
    private String gender;
    /** 생년월일 (YYYYMMDD) */
    @Column(name = "birth_date", length = 8, nullable = false)
    @Schema(description = "생년월일 (YYYYMMDD)", example = "19900101")
    private String birthDate;
    /** 소셜 로그인 제공자 (예: KA, GO) */
    @Column(length = 2)
    @Schema(description = "소셜 로그인 제공자 (예: KA, GO)", example = "GO")
    private String provider;
    /** 소셜 제공자 고유 ID */
    @Column(name = "provider_id", length = 100, nullable = false)
    @Schema(description = "소셜 제공자 고유 ID", example = "google-oauth2-1234567890")
    private String providerId;
    /** 계정 상태 (A: 활성, D: 삭제) */
    @Column(length = 1, nullable = false)
    @Builder.Default
    @Schema(description = "계정 상태 (A: 활성, D: 삭제)", example = "A")
    private String status = "A";
    /** 이메일 인증 여부 (Y/N) */
    @Column(name = "email_verified", length = 1, nullable = false)
    @Builder.Default
    @Schema(description = "이메일 인증 여부 (Y/N)", example = "N")
    private String emailVerified = "N";
    /** 계정 생성일 */
    @Column(name = "created_at", nullable = false, updatable = false)
    @Builder.Default
    @Schema(description = "계정 생성일", example = "2025-07-16T09:00:00")
    private LocalDateTime createdAt = LocalDateTime.now();
    /** 계정 수정일 */
    @Column(name = "updated_at")
    @Schema(description = "계정 수정일", example = "2025-07-17T10:00:00")
    private LocalDateTime updatedAt;
    /** 삭제일 (soft delete) */
    @Column(name = "deleted_at")
    @Schema(description = "삭제일 (soft delete)", example = "2025-08-01T00:00:00")
    private LocalDateTime deletedAt;
    /** 최근 로그인 시간 */
    @Column(name = "last_login_at")
    @Schema(description = "최근 로그인 시간", example = "2025-07-15T22:00:00")
    private LocalDateTime lastLoginAt;
    /** 계정 잠금 시간 */
    @Column(name = "locked_at")
    @Schema(description = "계정 잠금 시간", example = "2025-07-10T08:30:00")
    private LocalDateTime lockedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
