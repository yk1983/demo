-- public.bbs_clsg definition

-- Drop table

-- DROP TABLE public.bbs_clsg;

CREATE TABLE public.bbs_clsg (
                                 bbs_clsg_sn bigserial NOT NULL, -- 게시판카테고리일련번호
                                 bbs_tp_cd varchar(1) NOT NULL, -- 게시판유형코드(공통코드)
                                 bbs_nm varchar(100) NOT NULL, -- 게시판명칭
                                 expln text NULL, -- 설명
                                 del_yn varchar(1) DEFAULT 'N'::character varying NULL, -- 삭제여부
                                 crt_dt timestamp DEFAULT CURRENT_TIMESTAMP NULL, -- 생성일시
                                 mdfcn_dt timestamp NULL, -- 수정일시
                                 del_dt timestamp NULL, -- 삭제일시
                                 CONSTRAINT pk_bbs_clsg PRIMARY KEY (bbs_clsg_sn)
);
COMMENT ON TABLE public.bbs_clsg IS '게시판카테고리';

-- Column comments

COMMENT ON COLUMN public.bbs_clsg.bbs_clsg_sn IS '게시판카테고리일련번호';
COMMENT ON COLUMN public.bbs_clsg.bbs_tp_cd IS '게시판유형코드(공통코드)';
COMMENT ON COLUMN public.bbs_clsg.bbs_nm IS '게시판명칭';
COMMENT ON COLUMN public.bbs_clsg.expln IS '설명';
COMMENT ON COLUMN public.bbs_clsg.del_yn IS '삭제여부';
COMMENT ON COLUMN public.bbs_clsg.crt_dt IS '생성일시';
COMMENT ON COLUMN public.bbs_clsg.mdfcn_dt IS '수정일시';
COMMENT ON COLUMN public.bbs_clsg.del_dt IS '삭제일시';