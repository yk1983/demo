package com.example.demo.sample.domain.entity;

import com.example.demo.common.contants.UseYn;
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
public class CommonCodeDetail {
    /** 그룹코드 */
    @Id
    @Column(length = 5)
    private String groupCode;
    /** 상세코드 */
    @Id
    @Column(length = 3)
    private String code;
    /** 상세코드명칭 */
    @Column(nullable = false, length = 50)
    private String codeName;
    /** 속성1 */
    private String attribute1;
    /** 속성2 */
    private String attribute2;
    /** 속성3 */
    private String attribute3;
    /** 속성4 */
    private String attribute4;
    /** 속성5 */
    private String attribute5;
    /** 사용여부 */
    private String useYn = UseYn.USE.getCode();
    /** 정렬순서 */
    private Integer sortOrder = 0;
    /** 생성일시 */
    private LocalDateTime createdAt = LocalDateTime.now();
    /** 수정일시 */
    private LocalDateTime updatedAt;
}
