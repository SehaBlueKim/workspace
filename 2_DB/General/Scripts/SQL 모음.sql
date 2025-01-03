-- 예전 버전(11g 이전 버전) 오라클 구문 사용하기
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

CREATE USER community_ksh IDENTIFIED BY community1234;
      -- 사용자명             비밀번호

GRANT CONNECT, RESOURCE TO community_ksh;
-- CONNECT : DB 연결 권한 ROLE
-- RESOURCE : DB 기본 객체 생성 권한 ROLE

-- 객체(테이블 등)가 생성될 수 있는 공간 할당량 지정
ALTER USER community_ksh DEFAULT TABLESPACE SYSTEM QUOTA 
UNLIMITED ON SYSTEM;

----------------------------------------------------------------

CREATE TABLE "MEMBER" ( 
   "MEMBER_NO"   NUMBER   PRIMARY KEY,
   "MEMBER_EMAIL"   VARCHAR2(50) NOT NULL,
   "MEMBER_PW"   VARCHAR2(30) NOT NULL,
   "MEMBER_NICK"   VARCHAR2(30) NOT NULL,
   "MEMBER_TEL"   CHAR(11) NOT NULL,
   "MEMBER_ADDR"   VARCHAR2(500),
   "PROFILE_IMG"   VARCHAR2(200),
   "ENROLL_DT"   DATE DEFAULT SYSDATE ,
   "SECESSION_FL"   CHAR(1)   DEFAULT 'N'
);

COMMENT ON COLUMN "MEMBER"."MEMBER_NO" IS '회원 번호';
COMMENT ON COLUMN "MEMBER"."MEMBER_EMAIL" IS '회원 이메일(아이디)';
COMMENT ON COLUMN "MEMBER"."MEMBER_PW" IS '회원 비밀번호';
COMMENT ON COLUMN "MEMBER"."MEMBER_NICK" IS '회원 닉네임(중복x)';
COMMENT ON COLUMN "MEMBER"."MEMBER_TEL" IS '전화번호(- 미포함)';
COMMENT ON COLUMN "MEMBER"."MEMBER_ADDR" IS '회원 주소';
COMMENT ON COLUMN "MEMBER"."PROFILE_IMG" IS '회원 프로필 이미지';
COMMENT ON COLUMN "MEMBER"."ENROLL_DT" IS '회원 가입일';
COMMENT ON COLUMN "MEMBER"."SECESSION_FL" IS '탈퇴여부(Y:탈퇴, N:미탈퇴)';

-- 회원 번호 시퀀스
CREATE SEQUENCE SEQ_MEMBER_NO;

INSERT INTO MEMBER
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user01@kh.or.kr', 'pass01!', 
    '유저일', '01012341234', '04540,,서울특별시 강남구 테헤란로 14길 6 5층',
     NULL, DEFAULT, DEFAULT);

COMMIT;

SELECT * FROM MEMBER;

-- 이메일, 비밀번호가 일치하는 회원 조회
SELECT MEMBER_NO, MEMBER_EMAIL, MEMBER_NICK, MEMBER_TEL, MEMBER_ADDR, PROFILE_IMG, 
	   TO_CHAR(ENROLL_DT, 'YYYY-MM-DD HH24:MI:SS') AS ENROLL_DT 
FROM MEMBER
WHERE MEMBER_EMAIL = 'user01@kh.or.kr'
AND MEMBER_PW = 'pass01!'
AND SECESSION_FL = 'N';

-- 암호화 된 비밀번호로 업데이트
UPDATE MEMBER SET
MEMBER_PW = 'aBN5hiegXlvAovJLipPoPd5LB+xjPrAeu1tcAVg0p5MKGocvo6l825SD+ZMCOcHBFeGB7MnzH31SAnDzYYsSdg=='
WHERE MEMBER_NO = 1;

COMMIT;

-- 암호화 된 비밀번호가 너무 길어서 안들어가니까 MEMBER TABLE 비밀번호 컬럼 크기 변경
ALTER TABLE MEMBER 
MODIFY MEMBER_PW VARCHAR2(100);

