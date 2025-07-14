package com.example.demo.common.domain.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BaseResponse<T> {
    /** 응답 성공,실패 여부 */
    private boolean success;
    /** 응답 코드 */
    private String code;
    /** 응답 메세지 */
    private String message;
    /** 응답 객체 데이터 */
    private T data;
    /** 페이징 객체 (선택) */
    private PageInfo page;
    /** 유효성 오류 정보 (선택) */
    private List<FieldErrorDetail> errors;
}
