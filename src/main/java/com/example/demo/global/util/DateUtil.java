package com.example.demo.global.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {
    private static final String YYYYMMDD = "yyyyMMdd";
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd");
    /**
     * 📖 LocalDate → 문자열 (포맷 지정)
     * @param date 날짜
     * @param pattern 포맷
     * @return String
     */
    public static String format(LocalDate date, String pattern) {
        if (date == null || pattern == null) return null;
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 📖 LocalDate → 문자열 (포맷 지정)
     * @param date 날짜
     * @return String
     */
    public static String format(LocalDate date) {
        if (date == null) return null;
        return format(date, YYYYMMDD);
    }

    /**
     * 📖 LocalDateTime → 문자열 (포맷 지정)
     * @param dateTime 날짜
     * @param pattern 포맷
     * @return String
     */
    public static String format(LocalDateTime dateTime, String pattern) {
        if (dateTime == null || pattern == null) return null;
        return dateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 📖 LocalDateTime → 문자열 (포맷 지정)
     * @param dateTime 날짜
     * @return String
     */
    public static String format(LocalDateTime dateTime) {
        if (dateTime == null) return null;
        return format(dateTime, YYYYMMDD);
    }

    /**
     * yyyyMMdd 문자열을 구분자(delimiter)로 변경된 포맷으로 변환
     * @param value     예: 19900101
     * @param delimiter 예: "-", "/", "."
     * @return String   예: 1990-01-01, 1990/01/01, 1990.01.01 등
     * @throws IllegalArgumentException 잘못된 형식 입력 시
     */
    public static String formatToDelimitedDate(String value, String delimiter) {
        if (value == null || value.length() != 8) {
            throw new IllegalArgumentException("날짜 형식이 잘못되었습니다. yyyyMMdd 형식이어야 합니다.");
        }

        if (delimiter == null) {
            delimiter = "-";
        }

        try {
            LocalDate date = LocalDate.parse(value, INPUT_FORMAT);
            String pattern = String.join(delimiter, "yyyy", "MM", "dd");
            return date.format(DateTimeFormatter.ofPattern(pattern));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("⚠️ 날짜 파싱 실패: " + value, e);
        }
    }

    /**
     * yyyyMMdd 문자열을 구분자(-)로 변경된 포맷으로 변환
     * @param value     예: 19900101
     * @return String   예: 1990-01-01, 1990/01/01, 1990.01.01 등
     * @throws IllegalArgumentException 잘못된 형식 입력 시
     */
    public static String formatToDelimitedDate(String value) {
        return formatToDelimitedDate(value, "-");
    }

    /**
     * 📖 문자열 → LocalDate (포맷 지정)
     * @param dateStr 문자열
     * @param pattern 포멧
     * @return LocalDate
     */
    public static LocalDate parseToDate(String dateStr, String pattern) {
        if (dateStr == null || pattern == null) return null;
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 📖 문자열 → LocalDateTime (포맷 지정)
     * @param dateStr 문자열
     * @param pattern 포멧
     * @return LocalDateTime
     */
    public static LocalDateTime parseToDateTime(String dateStr, String pattern) {
        if (dateStr == null || pattern == null) return null;
        return LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }
}
