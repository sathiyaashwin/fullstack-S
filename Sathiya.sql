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

create table sathiyaa_product(product_id number (3) primary key , product_name varchar2 (20),price number(10,2));

insert into sathiyaa_product values(01,'tv',450)
insert into sathiyaa_product values(02,'fridge',11500)
insert into sathiyaa_product values(03,'laptop',25000)

create table sathiyaa_invoice(invoice_Number number(5) primary key , customer_name varchar2(20), quantity number(3), product_ref REFERENCES sathiyaa_product(product_id));

insert into sathiyaa_invoice values(201,'gowsick',1,01)
insert into sathiyaa_invoice values(202,'vishnu',5,02)
insert into sathiyaa_invoice values(203,'yovel',10,03)
insert into sathiyaa_invoice values(204,'viks',6,03)

describe sathiyaa_issue
describe sathiyaa_product



select sp.product_id,sp.product_name,sp.price,si.invoice_Number,si.customer_name,si.quantity from sathiyaa_product sp,sathiyaa_invoice  si where sp.product_id = si.product_ref

select sp.product_id,sp.product_name,si.customer_name,sp.price*si.quantity amount
from poov_product sp,poov_invoice si
where si.product_ref=sp.product_id;

select * from sathiyaa_product sp LEFT OUTER JOIN sathiyaa_invoice si on sp.product_id=si.product_ref

select * from sathiyaa_product sp RIGHT OUTER JOIN sathiyaa_invoice si on sp.product_id=si.product_ref


create view sathiyaa_product_view as select product_id,product_name from sathiyaa_product


insert into sathiyaa_product_view values (107,'mobile')

select view_name, text from user_views where view_name='SATHIYA_PRODUCT_VIEW';

create table sathiyaa_catalog(grade varchar(1) primary key,max_price number(10,2),min_price number(10,2));

insert into sathiyaa_catalog values('A',10000,1000);
insert into sathiyaa_catalog values('B',5000,500);
insert into sathiyaa_catalog values('C',3000,200);

select * from sathiyaa_catalog

select * from sathiyaa_product

select * from sathiyaa_Doctor
select * from sathiyaa_employee

CREATE INDEX product_name_index on sathiyaa_product(product_name);

select p.product_name , p.price , c.grade 
from sathiyaa_product p  , sathiyaa_catalog c
where p.price between c.max_price and c.min_price

select price from sathiyaa_product;

create table sathiyaa_bill(bill_number number (5) primary key,bill_date date,amount number(10,2),cus_ref number(3))

select * from sathiyaa_bill

create sequence sathiyaa_seq start with 101 increment by 1 maxvalue 1000

insert into sathiyaa_bill values (sathiyaa_seq.nextval,sysdate,14500,108)
insert into sathiyaa_bill values (sathiyaa_seq.nextval,sysdate,15680,109)
insert into sathiyaa_bill values (sathiyaa_seq.nextval,sysdate,17000,110)

update sathiyaa_bill set cus_ref = cus_ref +100 where cus_ref>105

select * from sathiyaa_bill

List of Bills on the same date as that of customer_ref =305

Select b.bill_number from sathiyaa_bill a,sathiyaa_bill b where a.cus_Ref=305 and a.bill_date=b.bill_date

select a.bill_number, b.bill_date from sathiyaa_bill a, sathiyaa_bill b where a. amount <b. amount



create sequence sathiyaa_seq1 start with 101 
increment by 1
maxvalue 1000

insert into sathiyaa_bill values(sathiyaa_seq1.nextval,sysdate,14580,101)
insert into sathiyaa_bill values(sathiyaa_seq1.nextval,sysdate,15896,102)
insert into sathiyaa_bill values(sathiyaa_seq1.nextval,sysdate,20546,103)
insert into sathiyaa_bill values(sathiyaa_seq1.nextval,sysdate,32568,101)
insert into sathiyaa_bill values(sathiyaa_seq1.nextval,sysdate,45623,102)

insert into sathiyaa_bill values(sathiyaa_seq1.nextval,to_date ('10-jan-2022')+5,52369,114)
insert into sathiyaa_bill values(sathiyaa_seq1.nextval,add_months(to_date('10-jan-2022'),5),9699,025)


update  sathiyaa_bill set cus_ref = cus_ref+100
update  sathiyaa_bill set amount = amount+1000

select * from sathiyaa_employee

select * from sathiyaa_bill;

 select b.bill_number,a.amount from sathiyaa_bill a, sathiyaa_bill b where a.cus_ref = 215 and a.bill_date = b.bill_date;
 
 create table sathiyaa_loan_application(application_number number(3),customer REFERENCES sathiyaa_customer(customer_id),loan_amount number(6))
 
 select * from sathiyaa_customer
 select * from sathiyaa_loan_application
 
 select * from sathiyaa_loan_application sl LEFT OUTER JOIN sathiyaa_customer sc on sl.customer=sc.customer_id
 
 select * from sathiyaa_loan_application sl RIGHT OUTER JOIN sathiyaa_customer sc on sl.customer=sc.customer_id
 
 select sc.customer_name,sc.phone_number,sc.credit_score,sl.loan_amount
 from sathiyaa_customer sc,sathiyaa_loan_application sl
 where sc.customer_id=sl.customer
 
 select sc.customer_id,sc.customer_name,sc.phone_number,sc.credit_score,sl.application_number,sl.customer,sl.loan_amount 
 from sathiyaa_loan_application sl,sathiyaa_customer sc 
 where sc.customer_id=sl.customer
 
 
 select * from Sathiya_Doctor_one_To_Many
 select * from sathiya_patient_one_to_many
 
 select * from Sathiyaspeak_one_to_one
 select * from Sathiyasem_one_to_one
 
 drop table Speaker_one_to_one
 drop table Seminar_one_to_one
 
 alter table sathiya_patient_one_to_many  set unused column patient_ref
 
 alter table Speaker_one_to_one set unused column speaker_duration
 
 DELETE FROM Sathiya_Doctor_one_To_Many WHERE Doctor_id = 201
 