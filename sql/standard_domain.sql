-- public.standard_domain definition

-- Drop table

-- DROP TABLE public.standard_domain;

CREATE TABLE public.standard_domain (
    domain_id bigserial NOT NULL, -- 번호 (일련번호)
    "version" int4 DEFAULT 1 NOT NULL, -- 제정차수
    group_name varchar(100) NOT NULL, -- 공통표준도메인그룹명
    category_name varchar(100) NOT NULL, -- 공통표준도메인분류명
    domain_name varchar(100) NOT NULL, -- 공통표준도메인명
    description text NULL, -- 공통표준도메인설명
    data_type varchar(50) NOT NULL, -- 데이터타입
    data_length int4 NULL, -- 데이터길이
    data_scale int4 NULL, -- 데이터소수점길이
    storage_format varchar(100) NULL, -- 저장형식
    display_format varchar(100) NULL, -- 표현형식
    unit varchar(50) NULL, -- 단위
    allowed_values text NULL, -- 허용값
    created_at timestamp DEFAULT CURRENT_TIMESTAMP NULL,
    updated_at timestamp NULL,
    CONSTRAINT standard_domain_pkey PRIMARY KEY (domain_id)
);
COMMENT ON TABLE public.standard_domain IS '표준 도메인 정보 테이블';

-- Column comments

COMMENT ON COLUMN public.standard_domain.domain_id IS '번호 (일련번호)';
COMMENT ON COLUMN public.standard_domain."version" IS '제정차수';
COMMENT ON COLUMN public.standard_domain.group_name IS '공통표준도메인그룹명';
COMMENT ON COLUMN public.standard_domain.category_name IS '공통표준도메인분류명';
COMMENT ON COLUMN public.standard_domain.domain_name IS '공통표준도메인명';
COMMENT ON COLUMN public.standard_domain.description IS '공통표준도메인설명';
COMMENT ON COLUMN public.standard_domain.data_type IS '데이터타입';
COMMENT ON COLUMN public.standard_domain.data_length IS '데이터길이';
COMMENT ON COLUMN public.standard_domain.data_scale IS '데이터소수점길이';
COMMENT ON COLUMN public.standard_domain.storage_format IS '저장형식';
COMMENT ON COLUMN public.standard_domain.display_format IS '표현형식';
COMMENT ON COLUMN public.standard_domain.unit IS '단위';
COMMENT ON COLUMN public.standard_domain.allowed_values IS '허용값';