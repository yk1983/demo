package com.example.demo.community.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "board_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "게시판 분류 Entity")
public class BoardCategory {
    /** 분류아이디 */
    @Id
    @Schema(description = "분류아이디", example = "1")
    /** 게시판유형 */
    private Long categoryId;
    @Column(length = 1, nullable = false)
    @Schema(description = "게시판유형", defaultValue = "G", example = "공통코드(G:일반 게시판, Q:문의 게시판, I:이미지 게시판)")
    private String boardType;
    /** 게시판명칭 */
    @Schema(description = "게시판명칭", example = "일반게시판")
    @Column(length = 100, nullable = false)
    private String boardName;
    /** 설명 */
    @Schema(description = "설명")
    private String description;
    /** 생성시각 */
    @Schema(description = "생성시각", defaultValue = "CURRENT_TIMESTAMP", example = "CURRENT_TIMESTAMP")
    private LocalDateTime createdAt = LocalDateTime.now();
    /** 수정시각 */
    @Schema(description = "수정시각", example = "CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
    /** 삭제시각 */
    @Schema(description = "삭제시각", example = "CURRENT_TIMESTAMP")
    private LocalDateTime deletedAt;
}
