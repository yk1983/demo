package com.example.demo.community.entity;

import java.io.Serializable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BoardId implements Serializable {
    /** 게시판분류일련번호 */
    private Long bbsClsgSn;
    /** 게시글일련번호 */
    private Long pstSn;
}