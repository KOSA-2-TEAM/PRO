DROP TABLE USERS CASCADE CONSTRAINTS;
DROP TABLE THEME CASCADE CONSTRAINTS;
DROP TABLE TRAVEL_BOARD CASCADE CONSTRAINTS;
DROP TABLE TRAVEL_LIKES CASCADE CONSTRAINTS;
DROP TABLE TRAVEL_IMAGES CASCADE CONSTRAINTS;
DROP TABLE VISITIED_LOCATIONS CASCADE CONSTRAINTS;
DROP TABLE REPORTS CASCADE CONSTRAINTS;
DROP TABLE BOARD CASCADE CONSTRAINTS;
DROP TABLE BOARD_FILES CASCADE CONSTRAINTS;
DROP TABLE REPLY CASCADE CONSTRAINTS;

DROP SEQUENCE USERS_SEQ;
DROP SEQUENCE THEME_SEQ;
DROP SEQUENCE TRAVEL_BOARD_SEQ;
DROP SEQUENCE TRAVEL_IMAGES_SEQ;
DROP SEQUENCE VISITIED_LOCATIONS_SEQ;
DROP SEQUENCE REPORTS_SEQ;
DROP SEQUENCE BOARD_SEQ;
DROP SEQUENCE BOARD_FILES_SEQ;
DROP SEQUENCE REPLY_SEQ;

-- 사용자 테이블
/*
authority : 디폴트 값 'user'(일반 사용자)
status : 디폴트 값 0(탈퇴 안함), 1(탈퇴 함)
[비고] : 해당 테이블 모든 칼럼 NULL 허용 안함.
*/
CREATE TABLE "USERS" (
    "users_idx"  NUMBER NOT NULL,
    "email"      VARCHAR(50) NOT NULL,
    "password"   NUMBER NOT NULL,
    "phone"      VARCHAR(50) NOT NULL,
    "nickname"   VARCHAR(50) NOT NULL,
    "created_at" DATE DEFAULT sysdate NOT NULL,
    "updated_at" DATE DEFAULT sysdate NOT NULL,
    "authority"  VARCHAR(50) DEFAULT 'user' NOT NULL,
    "status"     NUMBER(1) DEFAULT 0 NOT NULL
);

-- users_idx SEQUENCE
-- QUERY 예시 : INSERT INTO *** VALUES(USER_SEQ.NEXTVAL , ... )
CREATE SEQUENCE users_seq INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 999999 NOCYCLE NOCACHE NOORDER;
       
-------------------------------------------------------------------------

-- 테마 테이블
-- [비고] : 해당 테이블 모든 칼럼 NULL 허용 안함.
CREATE TABLE "THEME" (
    "theme_idx"  NUMBER NOT NULL,
    "name"       VARCHAR(30) NOT NULL,
    "travel_idx" NUMBER NOT NULL
);

-- theme_idx SEQUENCE
-- QUERY 예시 : INSERT INTO *** VALUES(THEME_SEQ.NEXTVAL , ... )
CREATE SEQUENCE theme_seq INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 999999 NOCYCLE NOCACHE NOORDER;

-------------------------------------------------------------------------

-- 여행앨범 테이블
/*
travel_idx : auto_increment
is_public : 디폴트 값 0(비공개), 1(공개)
status : 디폴트 값 0(탈퇴 안함), 1(탈퇴)
[비고] : content NULL 허용함.
*/
CREATE TABLE "TRAVEL_BOARD" (
    "travel_idx" NUMBER NOT NULL,
    "title"      VARCHAR(100) NOT NULL,
    "content"    VARCHAR(2000) NULL,
    "region"     VARCHAR(1000) NOT NULL,
    "start_date" DATE NOT NULL,
    "end_date"   DATE NOT NULL,
    "is_public"  NUMBER(1) DEFAULT 0 NOT NULL,
    "created_at" DATE DEFAULT sysdate NOT NULL,
    "updated_at" DATE DEFAULT sysdate NOT NULL
);

-- 앨범board_idx SEQUENCE
-- QUERY 예시 : INSERT INTO *** VALUES(TRAVEL_BOARD_SEQ.NEXTVAL , ... )
CREATE SEQUENCE travel_board_seq INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 999999 NOCYCLE NOCACHE NOORDER;
       
-------------------------------------------------------------------------

-- 여행 이미지 테이블
-- [비고] : 해당 테이블 모든 칼럼 NULL 허용 안함.
CREATE TABLE "TRAVEL_IMAGES" (
    "image_idx"   NUMBER NOT NULL,
    "travel_idx"  NUMBER NOT NULL,
    "imagepath"   VARCHAR(1000) NOT NULL,
    "uploaded_at" DATE DEFAULT sysdate NOT NULL
);

-- image_idx SEQUENCE
-- QUERY 예시 : INSERT INTO *** VALUES(TRAVEL_IMAGES_SEQ.NEXTVAL , ... )
CREATE SEQUENCE travel_images_seq INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 999999 NOCYCLE NOCACHE NOORDER;
       
-------------------------------------------------------------------------

-- 좋아요 테이블
-- [비고] : 해당 테이블 모든 칼럼 NULL 허용 안함.
CREATE TABLE "TRAVEL_LIKES" (
    "users_idx"  NUMBER NOT NULL,
    "travel_idx" NUMBER NOT NULL
);

-------------------------------------------------------------------------

-- 방문장소 테이블
-- [비고] : 해당 테이블 모든 칼럼 NULL 허용 안함.
CREATE TABLE "VISITIED_LOCATIONS" (
    "location_idx"  NUMBER NOT NULL,
    "travel_idx"    NUMBER NOT NULL,
    "location_name" VARCHAR(100) NOT NULL,
    "address"       VARCHAR(1000) NOT NULL
);

-- location_idx SEQUENCE
-- QUERY 예시 : INSERT INTO *** VALUES(VISITIED_LOCATIONS_SEQ.NEXTVAL , ... )
CREATE SEQUENCE visitied_locations_seq INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 999999 NOCYCLE NOCACHE NOORDER;
       
-------------------------------------------------------------------------

-- 신고 테이블
-- [비고] : 해당 테이블 모든 칼럼 NULL 허용 안함.
CREATE TABLE "REPORTS" (
    "report_idx" NUMBER NOT NULL,
    "content"    VARCHAR(1000) NOT NULL,
    "created_at" DATE DEFAULT sysdate NOT NULL,
    "updated_at" DATE DEFAULT sysdate NOT NULL,
    "users_idx"  NUMBER NOT NULL,
    "board_idx"  NUMBER NOT NULL
);

-- report_idx SEQUENCE
-- QUERY 예시 : INSERT INTO *** VALUES(REPORTS_SEQ.NEXTVAL , ... )
CREATE SEQUENCE reports_seq INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 999999 NOCYCLE NOCACHE NOORDER;
       
-------------------------------------------------------------------------

-- 게시판 테이블
/*
views : 디폴트 값 0
status : 디폴트 값 0(게시물 숨기지 않음), 1(게시물 숨김)
[비고] : answer_board_idx NULL 허용함.
*/
CREATE TABLE "BOARD" (
    "board_idx"        NUMBER NOT NULL,
    "title"            VARCHAR(100) NOT NULL,
    "content"          VARCHAR(2000) NOT NULL,
    "category"         VARCHAR(50) NOT NULL,
    "views"            NUMBER DEFAULT 0 NOT NULL,
    "status"           NUMBER(1) DEFAULT 0 NOT NULL,
    "created_at"       DATE DEFAULT sysdate NOT NULL,
    "updated_at"       DATE DEFAULT sysdate NOT NULL,
    "answer_board_idx" NUMBER NULL,
    "users_idx"        NUMBER NOT NULL
);

-- board_idx SEQUENCE
-- QUERY 예시 : INSERT INTO *** VALUES(BOARD_SEQ.NEXTVAL , ... )
CREATE SEQUENCE board_seq INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 999999 NOCYCLE NOCACHE NOORDER;
       
-------------------------------------------------------------------------

-- 게시판 파일 업로드 테이블
-- [비고] : 해당 테이블 모든 칼럼 NULL 허용 안함.
CREATE TABLE "BOARD_FILES" (
    "file_idx"    NUMBER NOT NULL,
    "filepath"    VARCHAR(1000) NOT NULL,
    "uploaded_at" DATE DEFAULT sysdate NOT NULL,
    "board_idx"   NUMBER NOT NULL
);

-- file_idx SEQUENCE
-- QUERY 예시 : INSERT INTO *** VALUES(BOARD_FILES_SEQ.NEXTVAL , ... )
CREATE SEQUENCE board_files_seq INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 999999 NOCYCLE NOCACHE NOORDER;
       
-------------------------------------------------------------------------

-- 댓글 테이블
-- [비고] : 해당 테이블 모든 칼럼 NULL 허용 안함.
CREATE TABLE "REPLY" (
    "reply_idx"  NUMBER NOT NULL,
    "content"    VARCHAR(2000) NOT NULL,
    "created_at" DATE DEFAULT sysdate NOT NULL,
    "updated_at" DATE DEFAULT sysdate NOT NULL,
    "board_idx"  NUMBER NOT NULL,
    "users_idx"  NUMBER NOT NULL
);

-- reply_idx SEQUENCE
-- QUERY 예시 : INSERT INTO *** VALUES(REPLY_SEQ.NEXTVAL , ... )
CREATE SEQUENCE reply_seq INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 999999 NOCYCLE NOCACHE NOORDER;
       
-------------------------------------------------------------------------

ALTER TABLE "USERS" ADD CONSTRAINT "PK_USERS" PRIMARY KEY ( "users_idx" );

ALTER TABLE "THEME" ADD CONSTRAINT "PK_THEME" PRIMARY KEY ( "theme_idx" );

ALTER TABLE "TRAVEL_BOARD" ADD CONSTRAINT "PK_TRAVEL_BOARD" PRIMARY KEY ( "travel_idx" );

ALTER TABLE "TRAVEL_IMAGES" ADD CONSTRAINT "PK_TRAVEL_IMAGES" PRIMARY KEY ( "image_idx" );

ALTER TABLE "TRAVEL_LIKES" ADD CONSTRAINT "PK_TRAVEL_LIKES" PRIMARY KEY ( "users_idx",
                                                                          "travel_idx" );

ALTER TABLE "VISITIED_LOCATIONS" ADD CONSTRAINT "PK_VISITIED_LOCATIONS" PRIMARY KEY ( "location_idx" );

ALTER TABLE "REPORTS" ADD CONSTRAINT "PK_REPORTS" PRIMARY KEY ( "report_idx" );

ALTER TABLE "BOARD" ADD CONSTRAINT "PK_BOARD" PRIMARY KEY ( "board_idx" );

ALTER TABLE "BOARD_FILES" ADD CONSTRAINT "PK_BOARD_FILES" PRIMARY KEY ( "file_idx" );

ALTER TABLE "REPLY" ADD CONSTRAINT "PK_REPLY" PRIMARY KEY ( "reply_idx" );

ALTER TABLE "TRAVEL_LIKES"
    ADD CONSTRAINT "FK_USER_TO_LIKES_1" FOREIGN KEY ( "users_idx" )
        REFERENCES "USERS" ( "users_idx" );

ALTER TABLE "TRAVEL_LIKES"
    ADD CONSTRAINT "FK_USER_TO_LIKES_2" FOREIGN KEY ( "travel_idx" )
        REFERENCES "TRAVEL_BOARD" ( "travel_idx" );