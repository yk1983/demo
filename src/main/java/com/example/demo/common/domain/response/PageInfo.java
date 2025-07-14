package com.example.demo.common.domain.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageInfo {
    private int page;
    private int size;
    private long total;
}
