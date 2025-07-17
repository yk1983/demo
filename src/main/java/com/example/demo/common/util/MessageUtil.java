package com.example.demo.common.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageUtil {

    private static MessageSource messageSource;

    public static String getMessage(String code, Locale locale) {
        return messageSource.getMessage(code, null, locale);
    }

    /**
     * ✅ 기본 로케일 기준 메시지 조회
     * @param code 메시지 코드
     * @return String
     */
    public static String getMessage(String code) {
        return getMessage(code, null, LocaleContextHolder.getLocale());
    }

    /**
     * ✅ 파라미터 포함 메시지 조회
     * @param code 메시지 코드
     * @param args 치환값 배열
     * @return String
     */
    public static String getMessage(String code, Object[] args) {
        return getMessage(code, args, LocaleContextHolder.getLocale());
    }

    /**
     * ✅ 특정 로케일 기준 메시지 조회
     * @param code 메시지 코드
     * @param args 치환값 배열
     * @param locale 언어
     * @return String
     */
    public static String getMessage(String code, Object[] args, Locale locale) {
        try {
            return messageSource.getMessage(code, args, locale);
        } catch (Exception e) {
            log.warn("메시지를 찾을 수 없습니다: {}, locale: {}", code, locale);
            return code; // 메시지 없으면 코드 그대로 반환
        }
    }
}
