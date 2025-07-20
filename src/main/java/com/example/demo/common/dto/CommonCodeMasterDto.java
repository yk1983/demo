package com.example.demo.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "공통코드 마스터 DTO")
public class CommonCodeMasterDto {
    /** 그룹코드 */
    @Schema(description = "그룹코드", example = "G0001")
    private String groupCode;
    /** 그룹명 */
    @Schema(description = "그룹명칭", example = "시스템구분")
    private String groupName;
    /** 설명 */
    @Schema(description = "설명")
    private String description;
    /** 사용여부 */
    @Schema(description = "사용여부", defaultValue = "Y", example = "Y")
    private String useYn;
    /** 정렬순서 */
    @Schema(description = "정렬순서", defaultValue = "0", example = "1")
    private Integer sortOrder;
}