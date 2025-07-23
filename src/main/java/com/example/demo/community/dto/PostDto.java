package com.example.demo.community.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {
    private Long bbsClsgSn;
    private Long pstSn;
    private String ttl;
    private String cn;
    private String wrtr;
    private Long userId;
    private Long inqCnt;
    private String ntcYn;
    private LocalDateTime ntcBgngDt;
    private LocalDateTime ntcEndDt;
    private String delYn;
    private LocalDateTime crtDt;
}
