-- public.user_withdrawal definition

-- Drop table

-- DROP TABLE public.user_withdrawal;

CREATE TABLE public.user_withdrawal (
                                        user_id bigserial NOT NULL, -- 사용자아이디
                                        email varchar(100) NOT NULL, -- 로그인용 이메일
                                        "password" varchar(256) NOT NULL, -- 비밀번호(BCrypt 암호화)
                                        "name" varchar(50) NOT NULL, -- 이름
                                        phone varchar(20) NOT NULL, -- 휴대전화번호
                                        gender bpchar(1) NOT NULL, -- 성별(공통코드:M/F)
                                        birth_date varchar(8) NOT NULL, -- 생년월일(YYYYMMDD)
                                        provider varchar(2) NULL, -- 로그인 제공자: (공통코드:LOCAL, GOOGLE, KAKAO)
                                        provider_id varchar(100) NOT NULL, -- SNS 제공자 유저 ID
                                        status bpchar(1) DEFAULT 'A'::bpchar NOT NULL, -- 상태(공통코드 : ACTIVE, SUSPENDED, WITHDRAWN)
                                        email_verified bpchar(1) DEFAULT 'N'::bpchar NOT NULL, -- 이메일인증여부
                                        created_at timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL, -- 계정생성일시
                                        updated_at timestamp NULL, -- 정보수정일시
                                        deleted_at timestamp NULL, -- 계정삭제일시
                                        last_login_at timestamp NULL, -- 마지막 로그인 일시
                                        locked_at timestamp NULL, -- 계정잠김일시
                                        CONSTRAINT pk_user_withdrawal PRIMARY KEY (user_id)
);
COMMENT ON TABLE public.user_withdrawal IS '사용자탈퇴';

-- Column comments

COMMENT ON COLUMN public.user_withdrawal.user_id IS '사용자아이디';
COMMENT ON COLUMN public.user_withdrawal.email IS '로그인용 이메일';
COMMENT ON COLUMN public.user_withdrawal."password" IS '비밀번호(BCrypt 암호화)';
COMMENT ON COLUMN public.user_withdrawal."name" IS '이름';
COMMENT ON COLUMN public.user_withdrawal.phone IS '휴대전화번호';
COMMENT ON COLUMN public.user_withdrawal.gender IS '성별(공통코드:M/F)';
COMMENT ON COLUMN public.user_withdrawal.birth_date IS '생년월일(YYYYMMDD)';
COMMENT ON COLUMN public.user_withdrawal.provider IS '로그인 제공자: (공통코드:LOCAL, GOOGLE, KAKAO)';
COMMENT ON COLUMN public.user_withdrawal.provider_id IS 'SNS 제공자 유저 ID';
COMMENT ON COLUMN public.user_withdrawal.status IS '상태(공통코드 : ACTIVE, SUSPENDED, WITHDRAWN)';
COMMENT ON COLUMN public.user_withdrawal.email_verified IS '이메일인증여부';
COMMENT ON COLUMN public.user_withdrawal.created_at IS '계정생성일시';
COMMENT ON COLUMN public.user_withdrawal.updated_at IS '정보수정일시';
COMMENT ON COLUMN public.user_withdrawal.deleted_at IS '계정삭제일시';
COMMENT ON COLUMN public.user_withdrawal.last_login_at IS '마지막 로그인 일시';
COMMENT ON COLUMN public.user_withdrawal.locked_at IS '계정잠김일시';