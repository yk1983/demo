package com.example.demo.community.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "bbs")
@Comment("게시판카테고리")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bbs_clsg_sn")
    @Comment("게시판카테고리일련번호")
    private Long bbsClsgSn;

    @Column(name = "bbs_tp_cd", nullable = false, length = 1)
    @Comment("게시판유형코드(공통코드)")
    private String bbsTpCd;
    /** bbs_tp_cd가 CommonCodeDetail을 참조 */
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "bbs_tp_cd", referencedColumnName = "code_id", insertable = false, updatable = false)
//    private CommonCodeDetail bbsType;

    @Column(name = "bbs_nm", nullable = false, length = 100)
    @Comment("게시판명칭")
    private String bbsNm;

    @Column(name = "expln", columnDefinition = "text")
    @Comment("설명")
    private String expln;

    @Column(name = "del_yn", length = 1, nullable = false)
    @Comment("삭제여부")
    private String delYn = "N";

    @CreationTimestamp
    @Column(name = "crt_dt", updatable = false)
    @Comment("생성일시")
    private LocalDateTime crtDt;

    @UpdateTimestamp
    @Column(name = "mdfcn_dt")
    @Comment("수정일시")
    private LocalDateTime mdfcnDt;

    @Column(name = "del_dt")
    @Comment("삭제일시")
    private LocalDateTime delDt;
}