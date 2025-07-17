package com.example.demo.common.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    private static final String YYYYMMDD = "yyyyMMdd";
    private static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter YYYYMMDDHHMMSS = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

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
