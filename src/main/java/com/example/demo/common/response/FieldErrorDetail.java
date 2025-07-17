package com.example.demo.common.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.validation.BindingResult;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "필드 오류 상세")
public class FieldErrorDetail {
    /** 오류필드명 */
    @Schema(description = "오류 필드명", example = "email")
    private String field;
    /** 오류메시지 */
    @Schema(description = "오류 메시지", example = "이메일 형식이 아닙니다.")
    private String message;

    public static List<FieldErrorDetail> from(BindingResult bindingResult) {
        return bindingResult.getFieldErrors().stream()
                .map(error -> new FieldErrorDetail(error.getField(), error.getDefaultMessage()))
                .toList();
    }
}