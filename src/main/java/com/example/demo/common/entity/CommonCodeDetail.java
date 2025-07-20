package com.example.demo.common.entity;

import com.example.demo.global.contants.UseYn;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "common_code_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(CommonCodeDetailId.class)
@Schema(description = "공통코드 상세 Entity")
public class CommonCodeDetail {
    /** 그룹코드 */
    @Id
    @Column(length = 5)
    @Schema(description = "그룹코드", example = "G0001")
    private String groupCode;
    /** 상세코드 */
    @Id
    @Column(length = 3)
    @Schema(description = "상세코드", example = "G")
    private String code;
    /** 상세코드명칭 */
    @Column(nullable = false, length = 50)
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
    private String useYn = UseYn.USE.getCode();
    /** 정렬순서 */
    @Schema(description = "정렬순서", defaultValue = "0", example = "1")
    private Integer sortOrder = 0;
    /** 생성일시 */
    @Schema(description = "생성일시", defaultValue = "CURRENT_TIMESTAMP", example = "CURRENT_TIMESTAMP")
    private LocalDateTime createdAt = LocalDateTime.now();
    /** 수정일시 */
    @Schema(description = "수정일시", example = "CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
}
