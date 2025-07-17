package com.example.demo.common.error;

import com.example.demo.common.contants.ErrorCode;
import com.example.demo.common.response.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        String accept = request.getHeader("Accept");
        String requestUri = request.getRequestURI();

        // TODO: JSON 요청
        if (accept != null && accept.contains(MediaType.APPLICATION_JSON_VALUE)) {
            ErrorResponse error = ErrorResponse.builder()
                    .code(ErrorCode.UNAUTHORIZED.getCode())
                    .message("인증이 필요합니다.")
                    .status(HttpServletResponse.SC_UNAUTHORIZED)
                    .path(requestUri)
                    .timestamp(LocalDateTime.now())
                    .build();

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);

            PrintWriter writer = response.getWriter();
            writer.write(objectMapper.writeValueAsString(error));
            writer.flush();
        }
        // TODO: HTML 요청 → 로그인 페이지로 이동
        else {
            response.sendRedirect("/login"); // 또는 "/login?redirect=" + URLEncoder.encode(requestUri)
        }
    }
}
