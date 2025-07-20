package com.example.demo.global.response;

import com.example.demo.global.contants.ErrorCode;
import com.example.demo.global.contants.SuccessCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Schema(description = "공통 응답 모델")
public class BaseResponse<T> {
    /** 응답 성공,실패 여부 */
    @Schema(description = "응답 성공,실패 여부", example = "true or false")
    private boolean success;
    /** 응답 코드 */
    @Schema(description = "응답 코드", example = "S200")
    private String code;
    /** 응답 메세지 */
    @Schema(description = "응답 메시지", example = "정상 처리되었습니다.")
    private String message;
    /** 응답 객체 데이터 */
    @Schema(description = "응답 데이터", example = "{...}")
    private T data;
    /** 페이징 객체 (선택) */
    @Schema(description = "페이징 객체 (선택)")
    private PageInfo page;
    /** 유효성 오류 정보 (선택) */
    @Schema(description = "유효성 오류 정보 (선택)")
    private List<FieldErrorDetail> errors;

    // ---------- Success --------------------
    public static <T> BaseResponse<T> success(T data, PageInfo page) {
        return BaseResponse.<T>builder()
                .success(true)
                .code(SuccessCode.SUCCESS.getCode())
                .message(SuccessCode.SUCCESS.getMessage())
                .data(data)
                .page(page)
                .errors(null)
                .build();
    }

    public static <T> BaseResponse<T> success(T data) {
        return success(data, null);
    }

    public static <T> BaseResponse<T> success() {
        return success(null);
    }

    // ---------- Error --------------------
    public static <T> BaseResponse<T> error(String code, String message, List<FieldErrorDetail> errors) {
        return BaseResponse.<T>builder()
                .success(false)
                .code(code)
                .message(message)
                .data(null)
                .page(null)
                .errors(errors)
                .build();
    }
    public static <T> BaseResponse<T> error(String code, String message) {
        return error(code, message, null);
    }

    public static <T> BaseResponse<T> error(ErrorCode errorCode) {
        return error(errorCode.getCode(), errorCode.getMessage());
    }

    public static <T> BaseResponse<T> error(ErrorCode errorCode, String message) {
        return error(errorCode.getCode(), message);
    }

    public static <T> BaseResponse<T> error(ErrorCode errorCode, List<FieldErrorDetail> errors) {
        return error(errorCode.getCode(), errorCode.getMessage(), errors);
    }

    public static <T> BaseResponse<T> error(ErrorCode errorCode, String message, List<FieldErrorDetail> errors) {
        return error(errorCode.getCode(), message, errors);
    }
}
