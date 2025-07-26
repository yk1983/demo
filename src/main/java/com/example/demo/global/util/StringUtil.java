package com.example.demo.global.util;

import java.util.regex.Pattern;

public class StringUtil {
    // TODO: 휴대폰 유효성 (010, 011, 016~019 포함, 10~11자리)
    private static final Pattern MOBILE_PATTERN = Pattern.compile("^01[016789]\\d{3,4}\\d{4}$");
    // TODO: 유선전화 (지역번호 02, 031, 등), 9~10자리
    private static final Pattern LANDLINE_PATTERN = Pattern.compile("^0\\d{1,2}\\d{3,4}\\d{4}$");

    /**
     * 전화번호 유효성 검사
     * @param rawNumber 전화번호 문자열
     * @return {boolean} 유효성 검사 결과
     */
    public static boolean isValidPhoneNumber(String rawNumber) {
        if (rawNumber == null) return false;

        // TODO: 숫자만 남김
        String digits = extractDigits(rawNumber);

        return MOBILE_PATTERN.matcher(digits).matches() || LANDLINE_PATTERN.matcher(digits).matches();
    }

    /**
     * 숫자 문자열 형태의 전화번호를 포맷된 형태로 변환
     * @param rawNumber 전화번호 문자열
     * @return {String} 포맷된 전화번호 (예: 01012345678 → 010-1234-5678)
     */
    public static String formatPhoneNumber(String rawNumber) {
        if (rawNumber == null) return "";

        // TODO: 숫자만 남김
        String digits = extractDigits(rawNumber);

        // TODO: 전화번호 자릿수 체크
        if (digits.length() == 11) {
            // TODO: 01012345678 → 010-1234-5678
            return digits.replaceFirst("(\\d{3})(\\d{4})(\\d{4})", "$1-$2-$3");
        } else if (digits.length() == 10) {
            if (digits.startsWith("02")) {
                // TODO: 021234567 → 02-1234-5678
                return digits.replaceFirst("(\\d{2})(\\d{4})(\\d{4})", "$1-$2-$3");
            } else {
                // TODO: 0311234567 → 031-123-4567
                return digits.replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "$1-$2-$3");
            }
        } else if (digits.length() == 9 && digits.startsWith("02")) {
            // TODO: 021234567 → 02-123-4567
            return digits.replaceFirst("(\\d{2})(\\d{3})(\\d{4})", "$1-$2-$3");
        }

        // TODO: 기본 fallback: 그대로 반환
        return rawNumber;
    }

    /**
     * 국제전화번호 포맷으로 변환
     * @param rawNumber 전화번호 문자열
     * @return {String} 포맷된 전화번호 (예: 01012345678 → +821012345678)
     */
    public static String formatToInternational(String rawNumber) {
        if (rawNumber == null) return "";

        // TODO: 숫자만 남김
        String digits = extractDigits(rawNumber);

        if (digits.startsWith("0")) {
            return "+82" + digits.substring(1);
        }

        return rawNumber;
    }

    /**
     * +82 또는 국제번호 형식의 전화번호를 국내 포멧으로 변환
     * @param intlNumber 국제번호 문자열
     * @return {String} 포맷된 전화번호 (예: +821012345678 → 010-1234-5678)
     */
    public static String formatFromInternational(String intlNumber) {
        if (intlNumber == null) return "";

        // TODO: 숫자만 추출하고 +82 → 0 으로 시작하도록 변환
        String digits = extractDigits(intlNumber);

        if (digits.startsWith("82")) {
            digits = "0" + digits.substring(2);
        }

        return formatPhoneNumber(digits); // 기존 하이픈 포맷 메서드 재활용
    }

    /**
     * 입력된 문자열에서 숫자만 추출하여 반환합니다.
     * @param input 입력된 문자열
     * @return {String} 숫자만 추출하여 반환
     */
    private static String extractDigits(String input) {
        return input == null ? "" : input.replaceAll("\\D", "");
    }
}
