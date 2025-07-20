package com.example.demo.global.config.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class LoggingAspect {
    private final ObjectMapper objectMapper;

    @Around("execution(* com.example.demo..controller..*(..))")
    public Object logController(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        long start = System.currentTimeMillis();
        String method = request.getMethod();
        String uri = request.getRequestURI();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String handlerName = signature.getDeclaringType().getSimpleName() + "." + signature.getMethod().getName() + "()";

        Object[] args = joinPoint.getArgs();
        String requestBody = extractRequestBody(args);

        log.info("│   📂 Handler     : {}", handlerName);
        log.info("│   📨 RequestBody : {}", requestBody);

        Object result = joinPoint.proceed();

        long elapsed = System.currentTimeMillis() - start;
        request.setAttribute("elapsedTime", elapsed);

        if (result instanceof String viewName) {
            log.info("│   🎯 ViewName    : {}", viewName);
        } else {
            log.info("│   ✅ Result      : {}", result != null ? result.getClass().getSimpleName() : "null");
        }

        return result;
    }

    private String extractRequestBody(Object[] args) {
        return Arrays.stream(args)
                .filter(arg ->
                        !(arg instanceof HttpServletRequest || arg instanceof HttpServletResponse || arg instanceof BindingResult)
                )
                .findFirst()
                .map(arg -> {
                    try {
                        return objectMapper.writeValueAsString(arg);
                    } catch (Exception e) {
                        return arg.toString();
                    }
                }).orElse("(none)");
    }
}
