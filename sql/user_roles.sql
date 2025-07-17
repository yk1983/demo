-- public.user_roles definition

-- Drop table

-- DROP TABLE public.user_roles;

CREATE TABLE public.user_roles (
                                   user_id int8 NOT NULL, -- 사용자아이디
                                   role_code int8 NOT NULL, -- 권한코드(공통코드)
                                   created_at timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
                                   CONSTRAINT pk_user_roles PRIMARY KEY (user_id, role_code)
);

-- Column comments

COMMENT ON COLUMN public.user_roles.user_id IS '사용자아이디';
COMMENT ON COLUMN public.user_roles.role_code IS '권한코드(공통코드)';