
/* 테이블 생성 */

CREATE TABLE EMP(E_NO NUMBER,
                            ID VARCHAR2(50),
                            PASS VARCHAR2(50),
                            NAME VARCHAR2(20),
                            PHONE_NUMBER VARCHAR2(20),
                            HIREDATE VARCHAR2(20),
                            SIGN VARCHAR2(50),
                            BASEPAY NUMBER,
                            C_NO NUMBER,
                            D_NO NUMBER);

         

CREATE TABLE CLUB(C_NO NUMBER,
                                C_NAME VARCHAR2(20),
                                C_DATE DATE,
                                C_MANAGER VARCHAR2(20));
                                
                                
CREATE TABLE COMMUNITY(CM_NO NUMBER,
                                        CM_PRICE VARCHAR2(20),
                                        CM_CONTENTS VARCHAR2(400),
                                        CM_DATE DATE,
                                        CM_TITLE VARCHAR2(50),
                                        CM_HITCOUNT NUMBER,
                                        CM_STATE VARCHAR2(50),
                                        CM_FNAME VARCHAR2(100),
                                        CM_FIN NUMBER,
                                        E_NO NUMBER);
                                        
                                        
CREATE TABLE REPLY(CM_R_NO NUMBER,
                                CM_R_CONTENTS VARCHAR2(400),
                                CM_R_DATE DATE,
                                E_NO NUMBER,
                                CM_NO NUMBER);
                                
                                
CREATE TABLE RESERVE (R_NO NUMBER,
                                    R_DATE DATE,
                                    R_STARTTIME VARCHAR2(20),
                                    R_ENDTIME VARCHAR2(20),
                                    MEETINGTITLE VARCHAR2(30),
                                    MR_NO NUMBER,
                                    E_NO NUMBER);
                                    
CREATE TABLE BOARD (B_NO NUMBER,
                                    B_TITLE VARCHAR2(50),
                                    B_CONTENTS VARCHAR2(400),
                                    B_FNAME VARCHAR2(100),
                                    B_DATE DATE,
                                    B_CATEGORY VARCHAR2(20),
                                    B_FIN NUMBER,
                                    E_NO NUMBER);
                                    
                                    
CREATE TABLE DEPT (D_NO NUMBER,
                                D_NAME VARCHAR2(20),
                                D_LOCATION VARCHAR2(20),
                                D_TEL_NUMBER VARCHAR2(20));
                                
CREATE TABLE MEETINGROOM (MR_NO NUMBER,
                                                MR_NAME VARCHAR2(20),
                                                MR_PERSONNEL NUMBER);
                                                
                                                
CREATE TABLE DOCUMENT (DC_NO NUMBER,
                                            DC_TITLE VARCHAR2(50),
                                            DC_CONTENTS VARCHAR2(400),
                                            DC_WRITER VARCHAR2(20),
                                            DC_FNAME VARCHAR2(100),
                                            DC_DATE DATE,
                                            DC_STATE VARCHAR2(20),
                                            E_NO NUMBER);
                                            

                                            
CREATE TABLE ATTENDANCE (A_NO NUMBER,
                                            A_DATE DATE,
                                            A_CHECKIN DATE,
                                            A_CHECKOUT DATE,
                                            E_NO NUMBER);
                                            

                                            
                                            
CREATE TABLE PAYSTUB (P_NO NUMBER,
                                        P_DATE DATE,
                                        P_NET_PAY NUMBER,
                                        E_NO NUMBER);
                                        
CREATE TABLE SCHEDULE (S_NO NUMBER,
                                        S_TITLE VARCHAR2(50),
                                        S_CONTENTS VARCHAR2(400),
                                        S_TYPE VARCHAR2(20),
                                        S_STARTDAY DATE,
                                        S_FINISHDAY DATE,
                                        S_DATE DATE,
                                        E_NO NUMBER);
                                        
CREATE TABLE PHONEBOOK(PB_NO NUMBER,
                                            PB_CPN VARCHAR2(30),
                                            PB_NAME VARCHAR2(20),
                                            PB_PHONE_NUMBER VARCHAR2(30),
                                            PB_RANK VARCHAR2(20),
                                            PB_EMAIL VARCHAR2(30),
                                            E_NO NUMBER);
                                            
CREATE TABLE ANNUAL (AN_NO NUMBER,
                                    AN_DISTINCT VARCHAR2(20),
                                    AN_DATE DATE,
                                    E_NO NUMBER);


CREATE TABLE APPROVER (AP_SEQ NUMBER,
                                        DC_NO NUMBER,
                                        AP_CHECK CHAR(1),
                                        AP_DATE DATE,
                                        E_NO NUMBER);
                                        
CREATE TABLE RECEIVER (RC_SEQ NUMBER,
                                        DC_NO NUMBER,
                                        E_NO NUMBER);
                                        
CREATE TABLE REFERRER (RF_SEQ NUMBER,
                                        DC_NO NUMBER,
                                        E_NO NUMBER);


/* 제약 조건 */
ALTER TABLE ANNUAL
	ADD CONSTRAINT  AN_NO_PK PRIMARY KEY (AN_NO);

ALTER TABLE APPROVER
	ADD CONSTRAINT  AP_PK PRIMARY KEY (AP_SEQ,DC_NO);

ALTER TABLE ATTENDANCE
	ADD CONSTRAINT  A_NO_PK PRIMARY KEY (A_NO);

ALTER TABLE BOARD
	ADD CONSTRAINT  B_NO_PK PRIMARY KEY (B_NO);

ALTER TABLE CLUB
	ADD CONSTRAINT  C_NO_PK PRIMARY KEY (C_NO);

ALTER TABLE COMMUNITY
	ADD CONSTRAINT  CM_NO_PK PRIMARY KEY (CM_NO);

ALTER TABLE DEPT
	ADD CONSTRAINT  D_NO_PK PRIMARY KEY (D_NO);

ALTER TABLE DOCUMENT
	ADD CONSTRAINT  DC_NO_PK PRIMARY KEY (DC_NO);

ALTER TABLE EMP
	ADD CONSTRAINT  E_NO_PK PRIMARY KEY (E_NO);

ALTER TABLE MEETINGROOM
	ADD CONSTRAINT  MR_NO_PK PRIMARY KEY (MR_NO);

ALTER TABLE PAYSTUB
	ADD CONSTRAINT  P_NO_PK PRIMARY KEY (P_NO);

ALTER TABLE PHONEBOOK
	ADD CONSTRAINT  PB_NO_PK PRIMARY KEY (PB_NO);

ALTER TABLE RECEIVER
	ADD CONSTRAINT  RC_PK PRIMARY KEY (RC_SEQ,DC_NO);

ALTER TABLE REFERRER
	ADD CONSTRAINT  RF_PK PRIMARY KEY (RF_SEQ,DC_NO);

ALTER TABLE REPLY
	ADD CONSTRAINT  CM_R_NO_PK PRIMARY KEY (CM_R_NO);

ALTER TABLE RESERVE
	ADD CONSTRAINT  R_NO_PK PRIMARY KEY (R_NO);

ALTER TABLE SCHEDULE
	ADD CONSTRAINT  S_NO_PK PRIMARY KEY (S_NO);


ALTER TABLE ANNUAL
	ADD (CONSTRAINT  AN_E_NO_FK FOREIGN KEY (E_NO) REFERENCES EMP(E_NO) ON DELETE SET NULL);




ALTER TABLE APPROVER
	ADD (CONSTRAINT  AP_E_NO_FK FOREIGN KEY (E_NO) REFERENCES EMP(E_NO) ON DELETE SET NULL);


ALTER TABLE APPROVER
	ADD (CONSTRAINT  AP_DC_NO_FK FOREIGN KEY (DC_NO) REFERENCES DOCUMENT(DC_NO));


ALTER TABLE ATTENDANCE
	ADD (CONSTRAINT   AT_E_NO_FK FOREIGN KEY (E_NO) REFERENCES EMP(E_NO) ON DELETE SET NULL); 

ALTER TABLE BOARD
	ADD (CONSTRAINT   B_E_NO_FK FOREIGN KEY (E_NO) REFERENCES EMP(E_NO) ON DELETE SET NULL);


ALTER TABLE COMMUNITY
	ADD (CONSTRAINT   CM_E_NO_FK FOREIGN KEY (E_NO) REFERENCES EMP(E_NO) ON DELETE SET NULL);


ALTER TABLE DOCUMENT
	ADD (CONSTRAINT  DC_E_NO_FK FOREIGN KEY (E_NO) REFERENCES EMP(E_NO) ON DELETE SET NULL);


ALTER TABLE EMP
	ADD (CONSTRAINT  E_D_NO_FK FOREIGN KEY (D_NO) REFERENCES DEPT(D_NO) ON DELETE SET NULL);


ALTER TABLE EMP
	ADD (CONSTRAINT  E_C_NO_FK FOREIGN KEY (C_NO) REFERENCES CLUB(C_NO) ON DELETE SET NULL);


ALTER TABLE PAYSTUB
	ADD (CONSTRAINT   P_E_NO_FK FOREIGN KEY (E_NO) REFERENCES EMP(E_NO) ON DELETE SET NULL);


ALTER TABLE PHONEBOOK
	ADD (CONSTRAINT   PB_E_NO_FK FOREIGN KEY (E_NO) REFERENCES EMP(E_NO) ON DELETE SET NULL);


ALTER TABLE RECEIVER
	ADD (CONSTRAINT  RC_E_NO_FK FOREIGN KEY (E_NO) REFERENCES EMP(E_NO) ON DELETE SET NULL);


ALTER TABLE RECEIVER
	ADD (CONSTRAINT   RC_DC_NO_FK FOREIGN KEY (DC_NO) REFERENCES DOCUMENT(DC_NO));


ALTER TABLE REFERRER
	ADD (CONSTRAINT   RF_E_NO_FK FOREIGN KEY (E_NO) REFERENCES EMP(E_NO) ON DELETE SET NULL);


ALTER TABLE REFERRER
	ADD (CONSTRAINT  RF_DC_NO_FK FOREIGN KEY (DC_NO) REFERENCES DOCUMENT(DC_NO));


ALTER TABLE REPLY
	ADD (CONSTRAINT   R_CM_NO_FK FOREIGN KEY (CM_NO) REFERENCES COMMUNITY(CM_NO) ON DELETE SET NULL);


ALTER TABLE REPLY
	ADD (CONSTRAINT   R_E_NO_FK FOREIGN KEY (E_NO) REFERENCES EMP(E_NO) ON DELETE SET NULL);


ALTER TABLE RESERVE
	ADD (CONSTRAINT  RS_E_NO_FK FOREIGN KEY (E_NO) REFERENCES EMP(E_NO) ON DELETE SET NULL);


ALTER TABLE RESERVE
	ADD (CONSTRAINT   RS_MR_NO_FK FOREIGN KEY (MR_NO) REFERENCES MEETINGROOM(MR_NO) ON DELETE SET NULL);


ALTER TABLE SCHEDULE
	ADD (CONSTRAINT   S_E_NO_FK FOREIGN KEY (E_NO) REFERENCES EMP(E_NO) ON DELETE SET NULL);
    
/* 시퀀스 */
CREATE SEQUENCE C_NO_SEQ;
CREATE SEQUENCE CM_NO_SEQ;
CREATE SEQUENCE CM_R_NO_SEQ;
CREATE SEQUENCE B_NO_SEQ;
CREATE SEQUENCE R_NO_SEQ;
CREATE SEQUENCE MR_NO_SEQ;
CREATE SEQUENCE AP_SEQ;
CREATE SEQUENCE RC_SEQ;
CREATE SEQUENCE DC_NO_SEQ;
CREATE SEQUENCE S_NO_SEQ;
CREATE SEQUENCE PB_NO_SEQ;
CREATE SEQUENCE A_NO_SEQ;
CREATE SEQUENCE P_NO_SEQ;
CREATE SEQUENCE AN_NO_SEQ;

