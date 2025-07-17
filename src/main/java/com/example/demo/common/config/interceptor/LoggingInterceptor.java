package com.example.demo.common.config.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoggingInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if (request.getRequestURI().startsWith("/css") ||
                request.getRequestURI().startsWith("/js") ||
                request.getRequestURI().startsWith("/images") ||
                request.getRequestURI().startsWith("/favicon.ico")) {
            return true; // skip logging
        }
        log.info("➡️  [{}] {}", request.getMethod(), request.getRequestURI());
        return true; // false면 요청 중단
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        log.debug("✅  Controller 실행 후 처리");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        log.info("⬅️  [{} {}] {} ({}ms)",
                response.getStatus(),
                HttpStatus.valueOf(response.getStatus()).getReasonPhrase(),
                request.getRequestURI(),
                request.getAttribute("elapsedTime")
        );
    }
}
