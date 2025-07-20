package com.example.demo.global.contants;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum UseYn {
    USE("Y", "사용"),
    NOT_USED("N", "미사용");

    private final String code;
    private final String label;

    /**
     * 코드로 enum 찾기
     * @param code 코드
     * @return Gender
     */
    @JsonCreator
    public static UseYn fromCode(String code) {
        return Arrays.stream(UseYn.values())
                .filter(v -> v.code.equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid UseYn code: " + code));
    }
}