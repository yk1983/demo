package com.example.demo.sample.domain.entity;

import com.example.demo.common.contants.UseYn;
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
public class CommonCodeMaster {
    /** 그룹코드 */
    @Id
    @Column(length = 50)
    private String groupCode;
    /** 그룹명 */
    @Column(nullable = false, length = 100)
    private String groupName;
    /** 설명 */
    private String description;
    /** 사용여부 */
    private String useYn = UseYn.USE.getCode();
    /** 정렬순서 */
    private Integer sortOrder = 0;
    /** 생성일시 */
    private LocalDateTime createdAt = LocalDateTime.now();
    /** 수정일시 */
    private LocalDateTime updatedAt;
}