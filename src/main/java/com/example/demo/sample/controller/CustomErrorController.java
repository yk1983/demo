package com.example.demo.sample.controller;

import com.example.demo.common.response.ErrorResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class CustomErrorController implements ErrorController {

    @RequestMapping
    public Object handleError(HttpServletRequest request, HttpServletResponse response) {
        Object statusAttr = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        int status = (statusAttr instanceof Integer) ? (Integer) statusAttr : HttpStatus.INTERNAL_SERVER_ERROR.value();
        String path = (String) request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
        String contentType = request.getHeader(HttpHeaders.ACCEPT);

        HttpStatus httpStatus = HttpStatus.resolve(status);
        ErrorResponse error = ErrorResponse.builder()
                .status(status)
                .code(httpStatus != null ? httpStatus.name() : "UNKNOWN")
                .message(getMessage(status))
                .path(path)
                .timestamp(LocalDateTime.now())
                .build();

        // TODO: JSON 응답
        if (contentType != null && contentType.contains((CharSequence) MediaType.APPLICATION_JSON)) {
            return ResponseEntity
                    .status(status)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(error);
        }

        // TODO: HTML 응답
        request.setAttribute("error", error);
        return "error/" + status; // ex) templates/error/404.html
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
