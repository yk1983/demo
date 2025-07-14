package com.example.demo.sample.domain.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonCodeMasterDto {
    private String groupCode;
    private String groupName;
    private String description;
    private String useYn;
    private Integer sortOrder;
}