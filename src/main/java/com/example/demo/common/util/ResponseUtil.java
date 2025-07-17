package com.example.demo.common.util;

import com.example.demo.common.response.BaseResponse;
import com.example.demo.common.response.FieldErrorDetail;
import com.example.demo.common.response.PageInfo;

import java.util.List;

public class ResponseUtil {

    public static <T> BaseResponse<T> success(T data) {
        return BaseResponse.<T>builder()
                .success(true)
                .code("SUCCESS")
                .message("처리 성공")
                .data(data)
                .build();
    }

    public static <T> BaseResponse<T> success(T data, PageInfo page) {
        return BaseResponse.<T>builder()
                .success(true)
                .code("SUCCESS")
                .message("처리 성공")
                .data(data)
                .page(page)
                .build();
    }

    public static BaseResponse<?> error(String code, String message) {
        return BaseResponse.builder()
                .success(false)
                .code(code)
                .message(message)
                .build();
    }

    public static BaseResponse<?> validationError(String code, String message, List<FieldErrorDetail> errors) {
        return BaseResponse.builder()
                .success(false)
                .code(code)
                .message(message)
                .errors(errors)
                .build();
    }
}