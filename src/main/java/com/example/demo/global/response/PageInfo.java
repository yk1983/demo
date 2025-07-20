package com.example.demo.global.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "페이징 정보 모델")
public class PageInfo {
    /** 페이지 번호 */
    @Schema(description = "페이지 번호", example = "1")
    private int page;
    /** 페이지 사이즈 */
    @Schema(description = "페이지 사이즈", example = "10")
    private int size;
    /** 전체 글 수 */
    @Schema(description = "전체 글 수", example = "165")
    private long total;
}
