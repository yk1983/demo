-- public.common_code_detail definition

-- Drop table

-- DROP TABLE public.common_code_detail;

CREATE TABLE public.common_code_detail (
    group_code varchar(5) NOT NULL,
    code varchar(3) NOT NULL,
    code_name varchar(50) NOT NULL,
    attribute1 varchar(200) NULL,
    attribute2 varchar(200) NULL,
    attribute3 varchar(200) NULL,
    attribute4 varchar(200) NULL,
    attribute5 varchar(200) NULL,
    use_yn varchar(1) DEFAULT 'Y'::character varying NULL,
    sort_order int4 DEFAULT 0 NULL,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP NULL,
    updated_at timestamp NULL,
    CONSTRAINT pk_common_code_detail PRIMARY KEY (group_code, code)
);