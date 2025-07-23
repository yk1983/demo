-- public.cmnt definition

-- Drop table

-- DROP TABLE public.cmnt;

CREATE TABLE public.cmnt (
	cmnt_sn bigserial NOT NULL, -- 댓글일련번호
	bbs_clsg_sn int8 NOT NULL, -- 게시판분류일련번호
	pst_sn int8 NOT NULL, -- 개시물일련번호
	cmnt_up_sn int8 NULL, -- 댓글상위일련번호
	cn varchar(1000) NOT NULL, -- 내용
	wrtr varchar(50) NOT NULL, -- 작성자
	user_id int8 NULL, -- 사용자아이디
	del_yn varchar(1) DEFAULT 'N'::character varying NULL, -- 삭제여부
	crt_dt timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL, -- 생성일시
	mdfcn_dt timestamp NULL, -- 수정일시
	del_dt timestamp NULL, -- 삭제일시
	CONSTRAINT pk_cmnt PRIMARY KEY (cmnt_sn)
);
COMMENT ON TABLE public.cmnt IS '댓글';

-- Column comments

COMMENT ON COLUMN public.cmnt.cmnt_sn IS '댓글일련번호';
COMMENT ON COLUMN public.cmnt.bbs_clsg_sn IS '게시판분류일련번호';
COMMENT ON COLUMN public.cmnt.pst_sn IS '개시물일련번호';
COMMENT ON COLUMN public.cmnt.cmnt_up_sn IS '댓글상위일련번호';
COMMENT ON COLUMN public.cmnt.cn IS '내용';
COMMENT ON COLUMN public.cmnt.wrtr IS '작성자';
COMMENT ON COLUMN public.cmnt.user_id IS '사용자아이디';
COMMENT ON COLUMN public.cmnt.del_yn IS '삭제여부';
COMMENT ON COLUMN public.cmnt.crt_dt IS '생성일시';
COMMENT ON COLUMN public.cmnt.mdfcn_dt IS '수정일시';
COMMENT ON COLUMN public.cmnt.del_dt IS '삭제일시';