package com.example.demo.common.contants;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum UserRole {
    ADMIN("A", "ADMIN", "관리자"),
    STUDENT("S", "STUDENT", "학생"),
    TEACHER("T", "TEACHER", "강사"),
    GUEST("G", "GUEST", "게스트");

    private final String code;
    private final String name;
    private final String description;

    /**
     * 코드로 enum 찾기
     * @param code 코드
     * @return UserRole
     */
    @JsonCreator
    public static UserRole fromCode(String code) {
        return Arrays.stream(UserRole.values())
                .filter(v -> v.code.equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid UserRole code: " + code));
    }

    @Override
    public String toString() {
        return code; // 저장 시 코드(A/S/T/G)로 저장되게끔
    }
}
