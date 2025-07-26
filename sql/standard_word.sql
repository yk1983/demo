-- public.standard_word definition

-- Drop table

-- DROP TABLE public.standard_word;

CREATE TABLE public.standard_word (
    word_id bigserial NOT NULL, -- 표준단어 일련번호
    "version" int4 NOT NULL, -- 제정차수
    word_name varchar(255) NOT NULL, -- 공통표준단어명
    word_abbr varchar(255) NULL, -- 공통표준단어영문약어명
    word_eng varchar(255) NULL, -- 공통표준단어영문명
    description text NULL, -- 공통표준단어 설명
    format_word_yn bool DEFAULT false NULL, -- 형식단어 여부
    domain_category_name varchar(255) NULL, -- 공통표준도메인분류명
    synonyms text NULL, -- 이음동의어 목록
    forbidden_words text NULL, -- 금칙어 목록
    created_at timestamp DEFAULT CURRENT_TIMESTAMP NULL, -- 생성일시
    updated_at timestamp NULL, -- 수정일시
    CONSTRAINT standard_word_pkey PRIMARY KEY (word_id)
);
COMMENT ON TABLE public.standard_word IS '표준단어 테이블';

-- Column comments

COMMENT ON COLUMN public.standard_word.word_id IS '표준단어 일련번호';
COMMENT ON COLUMN public.standard_word."version" IS '제정차수';
COMMENT ON COLUMN public.standard_word.word_name IS '공통표준단어명';
COMMENT ON COLUMN public.standard_word.word_abbr IS '공통표준단어영문약어명';
COMMENT ON COLUMN public.standard_word.word_eng IS '공통표준단어영문명';
COMMENT ON COLUMN public.standard_word.description IS '공통표준단어 설명';
COMMENT ON COLUMN public.standard_word.format_word_yn IS '형식단어 여부';
COMMENT ON COLUMN public.standard_word.domain_category_name IS '공통표준도메인분류명';
COMMENT ON COLUMN public.standard_word.synonyms IS '이음동의어 목록';
COMMENT ON COLUMN public.standard_word.forbidden_words IS '금칙어 목록';
COMMENT ON COLUMN public.standard_word.created_at IS '생성일시';
COMMENT ON COLUMN public.standard_word.updated_at IS '수정일시';