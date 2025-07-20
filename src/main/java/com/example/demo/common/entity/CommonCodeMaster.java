package com.example.demo.common.entity;

import com.example.demo.global.contants.UseYn;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "common_code_master")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "공통코드 마스터 Entity")
public class CommonCodeMaster {
    /** 그룹코드 */
    @Id
    @Column(length = 5)
    @Schema(description = "그룹코드", example = "G0001")
    private String groupCode;
    /** 그룹명 */
    @Column(length = 50, nullable = false)
    @Schema(description = "그룹명칭", example = "시스템구분")
    private String groupName;
    /** 설명 */
    @Schema(description = "설명")
    private String description;
    /** 사용여부 */
    @Schema(description = "사용여부", defaultValue = "Y", example = "Y")
    private String useYn = UseYn.USE.getCode();
    /** 정렬순서 */
    @Schema(description = "정렬순서", defaultValue = "0", example = "1")
    private Integer sortOrder = 0;
    /** 생성시각 */
    @Schema(description = "생성시각", defaultValue = "CURRENT_TIMESTAMP", example = "CURRENT_TIMESTAMP")
    private LocalDateTime createdAt = LocalDateTime.now();
    /** 수정시각 */
    @Schema(description = "수정시각", example = "CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
}