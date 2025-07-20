package com.example.demo.global.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    /** 시크릿 키는 최소 256비트 이상이어야 함 (HS256 기준) */
    private final Key SECRET_KEY = Keys.hmacShaKeyFor("YourSecretKeyMustBeAtLeast256BitsLongForHS256".getBytes(StandardCharsets.UTF_8));
    private final long EXPIRATION_MS = 1000 * 60 * 60; // 1시간 유효

    /**
     * ✅ 토큰 생성
     * @param username 사용자아이디
     * @return JWT 문자열
     */
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // 사용자 ID 등 주요 정보
                .setIssuedAt(new Date()) // 발급 시간
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS)) // 만료 시간
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256) // 서명
                .compact();
    }

    /**
     * ✅ 토큰 유효성 검증
     * @param token 토큰 문자열
     * @return true/false
     */
    public Boolean isValidateToken(String token) {
        try {
            getJwtParser().parseClaimsJws(token); // 파싱에 성공하면 유효
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * ✅ 내부 파서 생성
     * @return JwtParser
     */
    public JwtParser getJwtParser() {
        return Jwts.parserBuilder().setSigningKey(SECRET_KEY).build();
    }

    /**
     * ✅ 토큰에서 사용자명 추출
     * @param token 토큰 문자열
     * @return 사용자 정보
     */
    public String getUsername(String token) {
        return getJwtParser().parseClaimsJws(token).getBody().getSubject();
    }

    /**
     * ✅ HTTP 헤더에서 Bearer 토큰 추출
     * @param request 요청 객체
     * @return String "Bearer " 제외한 문자열 이후 토큰 문자열
     */
    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader(HttpHeaders.AUTHORIZATION);
        return (bearer != null && bearer.startsWith("Bearer ")) ? bearer.substring(7) : null;
    }

}
