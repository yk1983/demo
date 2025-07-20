package com.example.demo.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "공통코드 상세 DTO")
public class CommonCodeDetailDto {
    /** 그룹코드 */
    @Schema(description = "그룹코드", example = "G0001")
    private String groupCode;
    /** 상세코드 */
    @Schema(description = "상세코드", example = "G")
    private String code;
    /** 상세코드명칭 */
    @Schema(description = "상세코드명칭", example = "글로벌")
    private String codeName;
    /** 속성1 */
    @Schema(description = "속성1")
    private String attribute1;
    /** 속성2 */
    @Schema(description = "속성2")
    private String attribute2;
    /** 속성3 */
    @Schema(description = "속성3")
    private String attribute3;
    /** 속성4 */
    @Schema(description = "속성4")
    private String attribute4;
    /** 속성5 */
    @Schema(description = "속성5")
    private String attribute5;
    /** 사용여부 */
    @Schema(description = "사용여부", example = "Y")
    private String useYn;
    /** 정렬순서 */
    @Schema(description = "정렬순서", defaultValue = "0", example = "1")
    private Integer sortOrder;
}
