package com.example.demo.common.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonCodeDetailId implements Serializable {
    /** 그룹코드 */
    @Schema(description = "그룹코드", example = "G0001")
    private String groupCode;
    /** 상세코드 */
    @Schema(description = "상세코드", example = "G")
    private String code;
}
