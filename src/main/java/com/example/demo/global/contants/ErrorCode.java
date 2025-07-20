package com.example.demo.global.contants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // ✅ 인증 관련
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "E401", "인증이 필요합니다."),
    ACCESS_DENIED(HttpStatus.FORBIDDEN, "E403", "접근 권한이 없습니다."),
    // ✅ 회원가입 관련
    DUPLICATED_CODE(HttpStatus.BAD_REQUEST, "E400", "이미 존재하는 코드입니다."),
    DUPLICATED_EMAIL(HttpStatus.BAD_REQUEST, "E400", "이미 존재하는 이메일입니다."),
    DUPLICATED_PHONE(HttpStatus.BAD_REQUEST, "E400", "이미 존재하는 전화번호입니다."),
    DUPLICATED_USERNAME(HttpStatus.BAD_REQUEST, "E400", "이미 존재하는 사용자명입니다."),
    // ✅ 요청 오류
    INVALID_INPUT(HttpStatus.BAD_REQUEST, "E400", "입력값이 올바르지 않습니다."),
    NOT_FOUND(HttpStatus.NOT_FOUND, "E404", "데이터를 찾을 수 없습니다."),
    DATA_NOT_FOUND(HttpStatus.NOT_FOUND, "E404", "데이터를 찾을 수 없습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "E404", "사용자를 찾을 수 없습니다."),
    // ✅ 공통 에러
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E500", "서버 오류가 발생했습니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
