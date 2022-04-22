create table Gvsbook(book_Number number(5) PRIMARY KEY , book_name varchar2(20),author varchar2(20),price number(7,2));
describe Gvsbook

create table SathiyaStudent(student_name varchar2(20),student_Roll_Number number(5) PRIMARY KEY ,Branch varchar2(5),mark_scored number(3),dateOfBirth number(10));
describe SathiyaStudent


CREATE TABLE  Sathiya_author(PhoneNumber number(10)primary key,FirstName Varchar2(20),SecondName Varchar2(20),
City Varchar2(20),PinCode number(8));

describe Sathiya_author

CREATE TABLE  Sathya_book(PhoneNumber number(10) primary key ,BookName varchar2(20),Price number(10,2),authorRef number(10) REFERENCES Sathiya_author(PhoneNumber),City VArchar(20),PinCode number(7));

describe Sathya_book
SELECT*FROM SATHIYA_PRODUCT


create table sathiyaa_book(Book_No number(6) ,Book_Name varchar2(30),Author_name varchar2(30),Cost number(7,2),Category char(10));

create table sathiyaa_issue(Lib_Issue_Id number(10) ,Book_No number(6),Member_Id Number(5),Issue_Date date),Return_Date date);	

insert into sathiyaa_issue()

alter table sathiyaa_issue
add Reference varchar2(30)

describe sathiyaa_issue

alter table sathiyaa_issue
drop column Reference

rename sathiyaa_issue to sathiyaa_lib_issue

describe sathiyaa_lib_issue

insert into sathiyaa_member101 (select * from sathiyaa_member)

insert into sathiyaa_member values (1,'Richa Sharma','pune','10-Dec-05','Lifetime',2500,5,50)

insert into sathiyaa_member values(2,'Garima Sen','pune','22-April-22','Annual',1000,3,0)

describe sathiyaa_member

describe sathiyaa_member101

SELECT * FROM sathiyaa_member101


DROP TABLE SATHIYAA_MEMBER101
CREATE TABLE  SATHIYAA_MEMBER101 AS (SELECT * FROM SATHIYAA_MEMBER)

describe sathiyaa_book101

insert into sathiyaa_book101 (select * from sathiyaa_book)

select * from sathiyaa_book101

Insert into sathiyaa_book101  values(106,'National Geographic', 'Adis Scott', 1000,  'Science');
 
 
 
UPDATE sathiyaa_book
SET cost = 300, category = 'RDBMS'
WHERE book_no = 103 ;

DROP TABLE SATHIYA_ISSUE

 CREATE table Sathiya_issue(
                        LIB_ISSUE_ID number(10) PRIMARY KEY,
                        MEMBER_ID number(10) REFERENCES SATHIYAA_MEMBER(MEMBER_ID),
                        BOOK_NO NUMBER(10) REFERENCES SATHIYAA_MEMBER(MEMBER_ID),
                        ISSUE_DATE DATE,RETURN_DATE DATE, CONSTRAINT MEMEBER  CHECK(ISSUE_DATE < RETURN_DATE));


DESCRIBE SATHIYA_ISSUE
SELECT * FROM SATHIYA_ISSUE

INSERT INTO SATHIYA_ISSUE(LIB_ISSUE_ID,MEMBER_ID,BOOK_NO,ISSUE_DATE) VALUES(7001,101,101,'15-04-22')
INSERT INTO SATHIYA_ISSUE(LIB_ISSUE_ID,MEMBER_ID,BOOK_NO,ISSUE_DATE) VALUES(7002,102,102,'15-04-22')
INSERT INTO SATHIYA_ISSUE(LIB_ISSUE_ID,MEMBER_ID,BOOK_NO,ISSUE_DATE) VALUES(7003,103,103,'15-04-22')
INSERT INTO SATHIYA_ISSUE(LIB_ISSUE_ID,MEMBER_ID,BOOK_NO,ISSUE_DATE) VALUES(7004,104,104,'15-04-22')
INSERT INTO SATHIYA_ISSUE(LIB_ISSUE_ID,MEMBER_ID,BOOK_NO,ISSUE_DATE) VALUES(7005,110,69,'15-04-22')

DELETE FROM SATHIYA_ISSUE WHERE BOOK_NO = 69