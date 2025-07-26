package com.example.demo.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "standard_term")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StandardTerm {
    /** 표준용어 ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long termId;
    /** 제정차수 */
    private Integer version;
    /** 표준용어명 */
    @Column(nullable = false)
    private String termName;
    /** 표준용어 설명 */
    private String description;
    /** 영문약어명 */
    private String termAbbr;
    /** 도메인명 */
    private String domainName;
    /** 허용값 */
    private String allowedValues;
    /** 저장형식 */
    private String storageFormat;
    /** 표현형식 */
    private String displayFormat;
    /** 행정표준코드명 */
    private String adminStdCodeName;
    /** 소관기관명 */
    private String organization;
    /** 이음동의어 목록 */
    private String synonyms;
}
