-- public.atch_file definition

-- Drop table

-- DROP TABLE public.atch_file;

CREATE TABLE public.atch_file (
                                  file_sn bigserial NOT NULL, -- 파일일련번호
                                  atch_trgt_cd varchar(3) NOT NULL, -- 첨부대상코드
                                  atch_trgt_key varchar(20) NOT NULL, -- 첨부대상키
                                  file_path varchar(100) NOT NULL, -- 파일경로
                                  file_sz int8 DEFAULT 0 NOT NULL, -- 파일크기
                                  file_nm varchar(300) NOT NULL, -- 파일명
                                  uld_file_nm varchar(300) NOT NULL, -- 업로드파일명
                                  file_extn_nm varchar(5) NOT NULL, -- 파일확장자명
                                  del_yn varchar(1) DEFAULT 'N'::character varying NULL, -- 삭제여부
                                  crt_dt timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL, -- 생성일시
                                  del_dt timestamp NULL, -- 삭제일시
                                  CONSTRAINT pk_atch_file PRIMARY KEY (file_sn)
);
COMMENT ON TABLE public.atch_file IS '첨부파일';

-- Column comments

COMMENT ON COLUMN public.atch_file.file_sn IS '파일일련번호';
COMMENT ON COLUMN public.atch_file.atch_trgt_cd IS '첨부대상코드';
COMMENT ON COLUMN public.atch_file.atch_trgt_key IS '첨부대상키';
COMMENT ON COLUMN public.atch_file.file_path IS '파일경로';
COMMENT ON COLUMN public.atch_file.file_sz IS '파일크기';
COMMENT ON COLUMN public.atch_file.file_nm IS '파일명';
COMMENT ON COLUMN public.atch_file.uld_file_nm IS '업로드파일명';
COMMENT ON COLUMN public.atch_file.file_extn_nm IS '파일확장자명';
COMMENT ON COLUMN public.atch_file.del_yn IS '삭제여부';
COMMENT ON COLUMN public.atch_file.crt_dt IS '생성일시';
COMMENT ON COLUMN public.atch_file.del_dt IS '삭제일시';