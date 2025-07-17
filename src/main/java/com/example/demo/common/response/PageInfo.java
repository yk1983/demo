package com.example.demo.common.response;

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
