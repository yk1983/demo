package com.example.demo.global.contants;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Gender {
    MALE("M", "남성"),
    FEMALE("F", "여성");

    private final String code;
    private final String label;

    /**
     * 코드로 enum 찾기
     * @param code 코드
     * @return Gender
     */
    @JsonCreator
    public static Gender fromCode(String code) {
        return Arrays.stream(Gender.values())
                .filter(v -> v.code.equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Gender code: " + code));
    }
}
