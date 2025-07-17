-- public.common_code_master definition

-- Drop table

-- DROP TABLE public.common_code_master;

CREATE TABLE public.common_code_master (
    group_code varchar(5) NOT NULL, -- 그룹코드
    group_name varchar(30) NOT NULL, -- 그룹명칭
    description text NULL, -- 설명
    use_yn varchar(1) DEFAULT 'Y'::character varying NOT NULL, -- 사용여부
    sort_order int4 DEFAULT 0 NOT NULL, -- 정렬순서
    created_at timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL, -- 생성일자
    updated_at timestamp NULL, -- 수정일자
    CONSTRAINT pk_common_code_master PRIMARY KEY (group_code)
);
COMMENT ON TABLE public.common_code_master IS '공통코드';

-- Column comments

COMMENT ON COLUMN public.common_code_master.group_code IS '그룹코드';
COMMENT ON COLUMN public.common_code_master.group_name IS '그룹명칭';
COMMENT ON COLUMN public.common_code_master.description IS '설명';
COMMENT ON COLUMN public.common_code_master.use_yn IS '사용여부';
COMMENT ON COLUMN public.common_code_master.sort_order IS '정렬순서';
COMMENT ON COLUMN public.common_code_master.created_at IS '생성일자';
COMMENT ON COLUMN public.common_code_master.updated_at IS '수정일자';