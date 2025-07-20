package com.example.demo.global.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class GlobalErrorController implements ErrorController {

    @GetMapping
    public Object handleError(Model model, HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String path = (String) request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);

        model.addAttribute("path", path); // 경로 정보 전달

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            return switch (statusCode) {
                case 403 -> "error/403";    // → templates/error/403.html
                case 404 -> "error/404";    // → templates/error/404.html
                default -> "error/500";     // → templates/error/500.html
            };
        }
        return "error/500";
    }

    private String getMessage(int status) {
        return switch (status) {
            case 404 -> "요청하신 페이지를 찾을 수 없습니다.";
            case 403 -> "접근 권한이 없습니다.";
            case 500 -> "서버 내부 오류가 발생했습니다.";
            default -> "예상치 못한 오류가 발생했습니다.";
        };
    }
}
