package com.example.demo.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "표준 용어 DTO")
public class StandardTermDto {
    /** 표준용어 ID */
    @Schema(description = "표준용어 ID", example = "1")
    private Long termId;
    /** 제정차수 */
    @Schema(description = "제정차수", example = "1")
    private Integer version;
    /** 표준용어명 */
    @Schema(description = "표준용어명", example = "주소")
    private String termName;
    /** 표준용어 설명 */
    @Schema(description = "표준용어 설명", example = "거주지 주소를 나타냄")
    private String description;
    /** 영문약어명 */
    @Schema(description = "영문약어명", example = "ADDR")
    private String termAbbr;
    /** 도메인명 */
    @Schema(description = "도메인명", example = "개인정보")
    private String domainName;
    /** 허용값 */
    @Schema(description = "허용값", example = "서울,부산,대구")
    private String allowedValues;
    /** 저장형식 */
    @Schema(description = "저장형식", example = "VARCHAR(100)")
    private String storageFormat;
    /** 표현형식 */
    @Schema(description = "표현형식", example = "텍스트")
    private String displayFormat;
    /** 행정표준코드명 */
    @Schema(description = "행정표준코드명", example = "STD001")
    private String adminStdCodeName;
    /** 소관기관명 */
    @Schema(description = "소관기관명", example = "행정안전부")
    private String organization;
    /** 이음동의어 목록 */
    @Schema(description = "이음동의어 목록", example = "거주지,주소지")
    private String synonyms;
}
