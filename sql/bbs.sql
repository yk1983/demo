-- public.bbs definition

-- Drop table

-- DROP TABLE public.bbs;

CREATE TABLE public.bbs (
                            bbs_clsg_sn int8 NOT NULL, -- 게시판분류일련번호
                            pst_sn int8 NOT NULL, -- 게시물일련번호
                            pst_up_sn int8 NULL, -- 게시물상위일련번호
                            ttl varchar(200) NOT NULL, -- 제목
                            cn text NOT NULL, -- 내용
                            wrtr varchar(50) NOT NULL, -- 작성자
                            user_id int8 NULL, -- 사용자아이디
                            inq_cnt int8 DEFAULT 0 NULL, -- 조회수
                            ntc_yn varchar(1) DEFAULT 'N'::character varying NULL, -- 공지여부
                            ntc_bgng_dt timestamp NULL, -- 공지시작일시
                            ntc_end_dt timestamp NULL, -- 공지종료일시
                            del_yn varchar(1) DEFAULT 'N'::character varying NULL, -- 삭제여부
                            crt_dt timestamp DEFAULT CURRENT_TIMESTAMP NULL, -- 생성일시
                            mdfcn_dt timestamp NULL, -- 수정일시
                            del_dt timestamp NULL, -- 삭제일시
                            CONSTRAINT pk_bbs PRIMARY KEY (bbs_clsg_sn, pst_sn)
);
COMMENT ON TABLE public.bbs IS '게시판';

-- Column comments

COMMENT ON COLUMN public.bbs.bbs_clsg_sn IS '게시판분류일련번호';
COMMENT ON COLUMN public.bbs.pst_sn IS '게시물일련번호';
COMMENT ON COLUMN public.bbs.pst_up_sn IS '게시물상위일련번호';
COMMENT ON COLUMN public.bbs.ttl IS '제목';
COMMENT ON COLUMN public.bbs.cn IS '내용';
COMMENT ON COLUMN public.bbs.wrtr IS '작성자';
COMMENT ON COLUMN public.bbs.user_id IS '사용자아이디';
COMMENT ON COLUMN public.bbs.inq_cnt IS '조회수';
COMMENT ON COLUMN public.bbs.ntc_yn IS '공지여부';
COMMENT ON COLUMN public.bbs.ntc_bgng_dt IS '공지시작일시';
COMMENT ON COLUMN public.bbs.ntc_end_dt IS '공지종료일시';
COMMENT ON COLUMN public.bbs.del_yn IS '삭제여부';
COMMENT ON COLUMN public.bbs.crt_dt IS '생성일시';
COMMENT ON COLUMN public.bbs.mdfcn_dt IS '수정일시';
COMMENT ON COLUMN public.bbs.del_dt IS '삭제일시';