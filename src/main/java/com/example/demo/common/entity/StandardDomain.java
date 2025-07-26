package com.example.demo.common.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "standard_domain")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StandardDomain {
    /** 도메인ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long domainId;
    /** 제정차수 */
    private Integer version;
    /** 공통표준도메인그룹명 */
    private String groupName;
    /** 공통표준도메인분류명 */
    private String categoryName;
    /** 공통표준도메인명 */
    private String domainName;
    /** 공통표준도메인설명 */
    @Column(length = 1000)
    private String description;
    /** 데이터타입 (예: VARCHAR, INT, DATE) */
    private String dataType;
    /** 데이터길이 */
    private Integer dataLength;
    /** 데이터소수점길이 */
    private Integer dataScale;
    /** 저장형식 (예: YYYYMMDD, 99999, 5자리 이내 문자 ...) */
    private String storageFormat;
    /** 표현형식 (예: YYYY-MM-DD, 999,999 ...) */
    private String displayFormat;
    /** 단위 (예: 년월일, 원, %, 개 ...) */
    private String unit;
    /** 허용값 (콤마 구분 예: 'M,F' 또는 JSON) */
    @Column(length = 1000)
    private String allowedValues;
    /** 생성일시 */
    private LocalDateTime createdAt;
    /** 수정일시 */
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
