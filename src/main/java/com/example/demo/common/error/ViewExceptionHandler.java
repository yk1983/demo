package com.example.demo.common.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@ControllerAdvice
public class ViewExceptionHandler {
    // 404 Not Found
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle404(NoHandlerFoundException ex) {
        return "error/404";
    }

    // 403 Forbidden
    @ExceptionHandler(AccessDeniedException.class)
    public String handle403(AccessDeniedException ex) {
        return "error/403";
    }

    // 500 Internal Server Error
    @ExceptionHandler(Exception.class)
    public String handle500(Exception ex) {
        return "error/500";
    }
}
