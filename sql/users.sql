-- public.users definition

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
                              user_id bigserial NOT NULL, -- 사용자아이디
                              email varchar(100) NOT NULL, -- 로그인용 이메일
                              "password" varchar(256) NOT NULL, -- 비밀번호(BCrypt 암호화)
                              "name" varchar(50) NOT NULL, -- 이름
                              phone varchar(20) NOT NULL, -- 휴대전화번호
                              gender varchar(1) NOT NULL, -- 성별(공통코드:M/F)
                              birth_date varchar(8) NOT NULL, -- 생년월일(YYYYMMDD)
                              provider varchar(2) NULL, -- 로그인 제공자: (공통코드:LOCAL, GOOGLE, KAKAO)
                              provider_id varchar(100) NULL, -- SNS 제공자 유저 ID
                              status varchar(1) DEFAULT 'A'::character varying NOT NULL, -- 상태(공통코드 : ACTIVE, SUSPENDED, WITHDRAWN)
                              email_verified varchar(1) DEFAULT 'N'::character varying NOT NULL, -- 이메일인증여부
                              created_at timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL, -- 계정생성일시
                              updated_at timestamp NULL, -- 정보수정일시
                              deleted_at timestamp NULL, -- 계정삭제일시
                              last_login_at timestamp NULL, -- 마지막 로그인 일시
                              locked_at timestamp NULL, -- 계정잠김일시
                              CONSTRAINT pk_users PRIMARY KEY (user_id),
                              CONSTRAINT uk_users_email UNIQUE (email)
);
COMMENT ON TABLE public.users IS '사용자';

-- Column comments

COMMENT ON COLUMN public.users.user_id IS '사용자아이디';
COMMENT ON COLUMN public.users.email IS '로그인용 이메일';
COMMENT ON COLUMN public.users."password" IS '비밀번호(BCrypt 암호화)';
COMMENT ON COLUMN public.users."name" IS '이름';
COMMENT ON COLUMN public.users.phone IS '휴대전화번호';
COMMENT ON COLUMN public.users.gender IS '성별(공통코드:M/F)';
COMMENT ON COLUMN public.users.birth_date IS '생년월일(YYYYMMDD)';
COMMENT ON COLUMN public.users.provider IS '로그인 제공자: (공통코드:LOCAL, GOOGLE, KAKAO)';
COMMENT ON COLUMN public.users.provider_id IS 'SNS 제공자 유저 ID';
COMMENT ON COLUMN public.users.status IS '상태(공통코드 : ACTIVE, SUSPENDED, WITHDRAWN)';
COMMENT ON COLUMN public.users.email_verified IS '이메일인증여부';
COMMENT ON COLUMN public.users.created_at IS '계정생성일시';
COMMENT ON COLUMN public.users.updated_at IS '정보수정일시';
COMMENT ON COLUMN public.users.deleted_at IS '계정삭제일시';
COMMENT ON COLUMN public.users.last_login_at IS '마지막 로그인 일시';
COMMENT ON COLUMN public.users.locked_at IS '계정잠김일시';