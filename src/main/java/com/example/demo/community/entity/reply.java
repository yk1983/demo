package com.example.demo.community.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "cmnt")
@Comment("댓글")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cmnt_sn")
    @Comment("댓글일련번호")
    private Long cmntSn;

    @Column(name = "bbs_clsg_sn", nullable = false)
    @Comment("게시판분류일련번호")
    private Long bbsClsgSn;

    @Column(name = "pst_sn", nullable = false)
    @Comment("개시물일련번호")
    private Long pstSn;

    @Column(name = "cmnt_up_sn")
    @Comment("댓글상위일련번호")
    private Long cmntUpSn;

    @Column(name = "cn", nullable = false, length = 1000)
    @Comment("내용")
    private String cn;

    @Column(name = "wrtr", nullable = false, length = 50)
    @Comment("작성자")
    private String wrtr;

    @Column(name = "user_id")
    @Comment("사용자아이디")
    private Long userId;

    @Column(name = "del_yn", length = 1, nullable = false)
    @Comment("삭제여부")
    private String delYn = "N";

    @CreationTimestamp
    @Column(name = "crt_dt", nullable = false, updatable = false)
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