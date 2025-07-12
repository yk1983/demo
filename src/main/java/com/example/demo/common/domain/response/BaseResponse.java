package com.example.demo.common.domain.response;

import lombok.*;

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
}
