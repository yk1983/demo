package com.example.demo.community.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "atch_file")
@Comment("첨부파일")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_sn")
    @Comment("파일일련번호")
    private Long fileSn;

    @Column(name = "atch_trgt_cd", nullable = false, length = 3)
    @Comment("첨부대상코드")
    private String atchTrgtCd;

    @Column(name = "atch_trgt_key", nullable = false, length = 20)
    @Comment("첨부대상키")
    private String atchTrgtKey;

    @Column(name = "file_path", nullable = false, length = 100)
    @Comment("파일경로")
    private String filePath;

    @Column(name = "file_sz", nullable = false)
    @Comment("파일크기")
    private Long fileSz = 0L;

    @Column(name = "file_nm", nullable = false, length = 300)
    @Comment("파일명")
    private String fileNm;

    @Column(name = "uld_file_nm", nullable = false, length = 300)
    @Comment("업로드파일명")
    private String uldFileNm;

    @Column(name = "file_extn_nm", nullable = false, length = 5)
    @Comment("파일확장자명")
    private String fileExtnNm;

    @Column(name = "del_yn", nullable = false, length = 1)
    @Comment("삭제여부")
    private String delYn = "N";

    @CreationTimestamp
    @Column(name = "crt_dt", nullable = false, updatable = false)
    @Comment("생성일시")
    private LocalDateTime crtDt;

    @Column(name = "del_dt")
    @Comment("삭제일시")
    private LocalDateTime delDt;
}