package com.example.demo.community.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@IdClass(BoardId.class)
@Table(name = "pst")
@Comment("게시판")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @Column(name = "bbs_clsg_sn")
    @Comment("게시판분류일련번호")
    private Long bbsClsgSn;

    @Id
    @Column(name = "pst_sn")
    @Comment("게시물일련번호")
    private Long pstSn;

    @Column(name = "pst_up_sn")
    @Comment("게시물상위일련번호")
    private Long pstUpSn;

    @Column(name = "ttl", nullable = false, length = 200)
    @Comment("제목")
    private String ttl;

    @Column(name = "cn", columnDefinition = "text", nullable = false)
    @Comment("내용")
    private String cn;

    @Column(name = "wrtr", nullable = false, length = 50)
    @Comment("작성자")
    private String wrtr;

    @Column(name = "user_id")
    @Comment("사용자아이디")
    private Long userId;

    @Column(name = "inq_cnt", nullable = false)
    @Comment("조회수")
    private Long inqCnt = 0L;

    @Column(name = "ntc_yn", length = 1, nullable = false)
    @Comment("공지여부")
    private String ntcYn = "N";

    @Column(name = "ntc_bgng_dt")
    @Comment("공지시작일시")
    private LocalDateTime ntcBgngDt;

    @Column(name = "ntc_end_dt")
    @Comment("공지종료일시")
    private LocalDateTime ntcEndDt;

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