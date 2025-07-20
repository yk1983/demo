package com.example.demo.global.response;

import com.example.demo.global.contants.ErrorCode;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "에러 응답 모델")
public class ErrorResponse {
    /** 에러코드 */
    @Schema(description = "에러 코드", example = "E500")
    private String code;
    /** 에러메시지 */
    @Schema(description = "에러 메시지", example = "서버 오류가 발생했습니다.")
    private String message;
    /** HTTP 상태코드 */
    @Schema(description = "HTTP 상태 코드", example = "500")
    private int status;
    /** 요청경로 */
    @Schema(description = "요청 경로", example = "/api/board")
    private String path;
    /** 에러발생시각 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Schema(description = "에러 발생 시각", example = "2025-07-14T10:25:30")
    private LocalDateTime timestamp;
    /** 필드오류목록 */
    @Schema(description = "필드 오류 목록")
    private List<FieldErrorDetail> errors;

    public static ErrorResponse of(ErrorCode errorCode, HttpServletRequest request) {
        return ErrorResponse.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .status(errorCode.getStatus().value())
                .path(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static ErrorResponse of(ErrorCode errorCode, HttpServletRequest request, List<FieldErrorDetail> fieldErrors) {
        return ErrorResponse.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .status(errorCode.getStatus().value())
                .path(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .errors(fieldErrors)
                .build();
    }

    public static ErrorResponse of(String code, String message, int status, String path) {
        return ErrorResponse.builder()
                .code(code)
                .message(message)
                .status(status)
                .path(path)
                .timestamp(LocalDateTime.now())
                .build();
    }
}
