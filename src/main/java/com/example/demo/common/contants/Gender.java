package com.example.demo.common.contants;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {
    MALE("M", "남성", ""),
    FEMALE("F", "여성", "");

    private final String code;
    private final String name;
    private final String description;

    @JsonCreator
    public static Gender from(String value) {
        for (Gender gender : Gender.values()) {
            if (gender.name().equalsIgnoreCase(value) || gender.name.equals(value)) {
                return gender;
            }
        }
        throw new IllegalArgumentException("성별 값이 잘못되었습니다: " + value);
    }
}
