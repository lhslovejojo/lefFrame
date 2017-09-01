/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.2.0

Source Server         : 10.75.170.73-demo
Source Server Version : 110200
Source Host           : 10.75.170.73:1521
Source Schema         : DEMO

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2017-09-01 18:34:01
*/


-- ----------------------------
-- Table structure for ASYN_NOTICE_INFO
-- ----------------------------
DROP TABLE "DEMO"."ASYN_NOTICE_INFO";
CREATE TABLE "DEMO"."ASYN_NOTICE_INFO" (
"ID" NUMBER(18) NOT NULL ,
"CONTENT" VARCHAR2(500 BYTE) NULL ,
"SEND_STATUS" VARCHAR2(20 BYTE) NULL ,
"CREATE_TIME" TIMESTAMP(0)  NULL ,
"SEND_TIME" TIMESTAMP(0)  NULL ,
"BIZ_NO" VARCHAR2(30 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Table structure for ORDER_INFO
-- ----------------------------
DROP TABLE "DEMO"."ORDER_INFO";
CREATE TABLE "DEMO"."ORDER_INFO" (
"CUSTOMER_ID" VARCHAR2(18 BYTE) NULL ,
"ORDER_AMOUNT" NUMBER NULL ,
"STATUS" VARCHAR2(4 BYTE) NULL ,
"ID" NUMBER(18) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Table structure for PAYMENT_INFO
-- ----------------------------
DROP TABLE "DEMO"."PAYMENT_INFO";
CREATE TABLE "DEMO"."PAYMENT_INFO" (
"ID" NUMBER(18) NOT NULL ,
"ORDER_ID" NUMBER(18) NULL ,
"PAY_TYPE" VARCHAR2(20 BYTE) NULL ,
"PAY_AMOUNT" NUMBER NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Sequence structure for SEQ_ASYN_NOTICE_INFO
-- ----------------------------
DROP SEQUENCE "DEMO"."SEQ_ASYN_NOTICE_INFO";
CREATE SEQUENCE "DEMO"."SEQ_ASYN_NOTICE_INFO"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 21
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_ORDER_INFO
-- ----------------------------
DROP SEQUENCE "DEMO"."SEQ_ORDER_INFO";
CREATE SEQUENCE "DEMO"."SEQ_ORDER_INFO"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 41
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_PAYMENT_INFO
-- ----------------------------
DROP SEQUENCE "DEMO"."SEQ_PAYMENT_INFO";
CREATE SEQUENCE "DEMO"."SEQ_PAYMENT_INFO"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 41
 CACHE 20;

-- ----------------------------
-- Indexes structure for table ASYN_NOTICE_INFO
-- ----------------------------

-- ----------------------------
-- Uniques structure for table ASYN_NOTICE_INFO
-- ----------------------------
ALTER TABLE "DEMO"."ASYN_NOTICE_INFO" ADD UNIQUE ("BIZ_NO");

-- ----------------------------
-- Checks structure for table ASYN_NOTICE_INFO
-- ----------------------------
ALTER TABLE "DEMO"."ASYN_NOTICE_INFO" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table ASYN_NOTICE_INFO
-- ----------------------------
ALTER TABLE "DEMO"."ASYN_NOTICE_INFO" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table ORDER_INFO
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table ORDER_INFO
-- ----------------------------
ALTER TABLE "DEMO"."ORDER_INFO" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table PAYMENT_INFO
-- ----------------------------

-- ----------------------------
-- Checks structure for table PAYMENT_INFO
-- ----------------------------
ALTER TABLE "DEMO"."PAYMENT_INFO" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table PAYMENT_INFO
-- ----------------------------
ALTER TABLE "DEMO"."PAYMENT_INFO" ADD PRIMARY KEY ("ID");
