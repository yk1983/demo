package com.example.demo.sample.domain.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonCodeDetailDto {
    private String groupCode;
    private String code;
    private String codeName;
    private String attribute1;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;
    private String useYn;
    private Integer sortOrder;
}
