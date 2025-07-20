package com.example.demo.global.error;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ViewExceptionHandler {
    @ExceptionHandler(AccessDeniedException.class)
    public String handle403(AccessDeniedException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "error/403"; // templates/error/403.html
    }

    @ExceptionHandler(Exception.class)
    public String handle500(Exception ex, HttpServletRequest request, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "error/500";
    }
}
