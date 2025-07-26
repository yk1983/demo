package com.example.demo.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "표준 도메인 정보")
public class StandardDomainDto {
    /** 도메인 ID */
    @Schema(description = "도메인 ID", example = "1")
    private Long domainId;
    /** 제정차수 */
    @Schema(description = "제정차수", example = "1")
    private Integer version;
    /** 도메인 그룹명 */
    @Schema(description = "도메인 그룹명", example = "기본정보")
    private String groupName;
    /** 도메인 분류명 */
    @Schema(description = "도메인 분류명", example = "개인")
    private String categoryName;
    /** 도메인명 */
    @Schema(description = "도메인명", example = "성별코드")
    private String domainName;
    /** 설명 */
    @Schema(description = "설명")
    private String description;
    /** 데이터 타입 */
    @Schema(description = "데이터 타입", example = "VARCHAR")
    private String dataType;
    /** 데이터 길이 */
    @Schema(description = "데이터 길이", example = "20")
    private Integer dataLength;
    /** 소수점 길이 */
    @Schema(description = "소수점 길이", example = "0")
    private Integer dataScale;
    /** 저장 형식 */
    @Schema(description = "저장 형식", example = "YYYYMMDD")
    private String storageFormat;
    /** 표현 형식 */
    @Schema(description = "표현 형식", example = "YYYY-MM-DD")
    private String displayFormat;
    /** 단위 */
    @Schema(description = "단위", example = "개")
    private String unit;
    /** 허용값 */
    @Schema(description = "허용값", example = "M,F")
    private String allowedValues;
}
