package com.example.demo.common.contants;

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

    public static UseYn fromCode(String code) {
        return Arrays.stream(UseYn.values())
                .filter(v -> v.code.equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid UseYn code: " + code));
    }
}