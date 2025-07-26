package com.example.demo.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "표준 단어 응답 DTO")
public class StandardWordDto {
    /** 표준단어 ID */
    @Schema(description = "표준단어 ID", example = "1")
    private Long wordId;
    /** 제정차수 */
    @Schema(description = "제정차수", example = "1")
    private Integer version;
    /** 표준단어명 */
    @Schema(description = "표준단어명", example = "고객명", required = true)
    private String wordName;
    /** 표준단어 영문 약어 */
    @Schema(description = "표준 단어 영문 약어", example = "CUST_NM")
    private String wordAbbr;
    /** 표준단어 영문명 */
    @Schema(description = "표준단어 영문명", example = "CustomerName")
    private String wordEng;
    /** 표준단어 설명 */
    @Schema(description = "표준단어 설명", example = "고객명을 나타내는 단어입니다.")
    private String description;
    /** 표준단어여부 */
    @Schema(description = "형식단어여부", example = "N")
    private String formatWordYn;
    /** 표준도메인 분류명 */
    @Schema(description = "표준도메인 분류명", example = "개인정보")
    private String domainCategoryName;
    /** 이음동의어 목록 (, 구분) */
    @Schema(description = "이음동의어 목록 (쉼표 구분)", example = "이름,성명")
    private String synonyms;
    /** 금칙어 목록 (, 구분) */
    @Schema(description = "금칙어 목록 (쉼표 구분)", example = "고객번호,고객아이디")
    private String forbiddenWords;
    /** 등록일시 */
    @Schema(description = "등록일시", example = "2025-07-20T09:00:00")
    private LocalDateTime createdAt;
    /** 수정일시 */
    @Schema(description = "수정일시", example = "2025-07-21T13:30:00")
    private LocalDateTime updatedAt;
}
