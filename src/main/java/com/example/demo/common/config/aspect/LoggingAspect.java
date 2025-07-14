package com.example.demo.common.config.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Pointcut("execution(* com.example..controller..*(..))")
    public void controllerMethods() {}

    @Around("controllerMethods()")
    public Object logRequestResponse(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = getCurrentHttpRequest();
        if (request == null) return joinPoint.proceed();

        String requestUri = request.getRequestURI();
        String httpMethod = request.getMethod();
        String queryString = request.getQueryString();
        String requestBody = extractRequestBody(joinPoint.getArgs());

        log.info("🌐 REQUEST [{} {}] {}", httpMethod, requestUri, queryString != null ? "?" + queryString : "");
        log.info("📦 Request Body: {}", requestBody);

        long start = System.currentTimeMillis();
        Object result = null;
        try {
            result = joinPoint.proceed();
            long end = System.currentTimeMillis();
            long duration = end - start;

            log.info("✅ RESPONSE [{} {}] ({}ms)", httpMethod, requestUri, duration);
            if (result instanceof ResponseEntity<?> responseEntity) {
                log.info("✅ ResponseEntity: {}", objectMapper.writeValueAsString(responseEntity.getBody()));
            } else {
                log.info("✅ Result: {}", objectMapper.writeValueAsString(result));
            }
            return result;
        } catch (Throwable ex) {
            log.error("❌ EXCEPTION [{} {}] - {}", httpMethod, requestUri, ex.getMessage(), ex);
            throw ex;
        }
    }

    private HttpServletRequest getCurrentHttpRequest() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return (attr != null) ? attr.getRequest() : null;
    }

    private String extractRequestBody(Object[] args) {
        return Arrays.stream(args)
                .filter(arg -> !(arg instanceof HttpServletRequest) && !(arg instanceof HttpServletResponse))
                .map(arg -> {
                    try {
                        return objectMapper.writeValueAsString(arg);
                    } catch (JsonProcessingException e) {
                        return "[unserializable]";
                    }
                })
                .collect(Collectors.joining(", "));
    }
}
