package com.example.demo.common.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "standard_word")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StandardWord {
    /** 표준단어 ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wordId;
    /** 제정차수 */
    private Integer version;
    /** 공통표준단어명 */
    @Column(nullable = false)
    private String wordName;
    /** 공통표준단어영문약어명 */
    private String wordAbbr;
    /** 공통표준단어영문명 */
    private String wordEng;
    /** 공통표준단어설명 */
    @Column(columnDefinition = "TEXT")
    private String description;
    /** 형식단어여부 */
    @Column(nullable = false)
    private String formatWordYn = "N";
    /** 공통표준도메인분류명 */
    private String domainCategoryName;
    /** 이음동의어목록 */
    @Column(columnDefinition = "TEXT")
    private String synonyms;
    /** 금칙어목록 */
    @Column(columnDefinition = "TEXT")
    private String forbiddenWords;
    /** 생성일시 */
    @Column(nullable = false, updatable = false)
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
