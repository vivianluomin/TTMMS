CREATE DATABASE ttms;

USE ttms;

/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/5/16 15:40:40                           */
/*==============================================================*/



DROP TABLE IF EXISTS employee;

DROP TABLE IF EXISTS USER;

DROP TABLE IF EXISTS play;

DROP TABLE IF EXISTS sale;

DROP TABLE IF EXISTS sale_item;

DROP TABLE IF EXISTS SCHEDULE;

DROP TABLE IF EXISTS seat;

DROP TABLE IF EXISTS studio;

DROP TABLE IF EXISTS ticket;

/*==============================================================*/
/* Table: data_dict                                             */
/*==============================================================*/
CREATE TABLE data_dict
(
   dict_id              INT NOT NULL AUTO_INCREMENT,
   dict_parent_id       INT,
   dict_index           INT,
   dict_name            VARCHAR(200),
   dict_value           VARCHAR(100) NOT NULL,
   PRIMARY KEY (dict_id)
);

/*==============================================================*/
/* Table: employee                                              */
/*==============================================================*/
CREATE TABLE employee
(
   emp_id               INT NOT NULL AUTO_INCREMENT,
   emp_no               CHAR(20) NOT NULL,
   emp_name             VARCHAR(100) NOT NULL,
   emp_tel_num          CHAR(20),
   emp_addr             VARCHAR(200),
   emp_email            VARCHAR(100),
   PRIMARY KEY (emp_id)
);

/*==============================================================*/
/* Table: user                                                 */
/*==============================================================*/
CREATE TABLE USER
(
	user_id			INT PRIMARY KEY,
	user_account			CHAR(10),
	user_password			CHAR(10)
);

/*==============================================================*/
/* Table: play                                                  */
/*==============================================================*/
CREATE TABLE play
(
   play_id              INT NOT NULL AUTO_INCREMENT,
   play_name            VARCHAR(200),
   play_introduction    VARCHAR(2000),
   play_image           LONGBLOB,
   play_length          INT,
   play_ticket_price    NUMERIC(10,2),
   play_status          SMALLINT COMMENT 'ȡֵ���壺
            0���������ݳ�
            1���Ѱ����ݳ�
            -1������',
   PRIMARY KEY (play_id)
);

/*==============================================================*/
/* Table: sale                                                  */
/*==============================================================*/
CREATE TABLE sale
(
   sale_ID              BIGINT NOT NULL AUTO_INCREMENT,
   emp_id               INT,
   sale_time            VARCHAR(10),
   sale_payment         DECIMAL(10,2),
   sale_change          NUMERIC(10,2),
   sale_type            SMALLINT COMMENT '���ȡֵ���壺
            1�����۵�
            -1���˿',
   sale_status          SMALLINT COMMENT '���۵�״̬���£�
            0��������
            1���Ѹ���',
   PRIMARY KEY (sale_ID)
);

/*==============================================================*/
/* Table: sale_item                                             */
/*==============================================================*/
CREATE TABLE sale_item
(
   sale_item_id         BIGINT NOT NULL AUTO_INCREMENT,
   ticket_id            BIGINT,
   sale_ID              BIGINT,
   sale_item_price      NUMERIC(10,2),
   PRIMARY KEY (sale_item_id)
);

/*==============================================================*/
/* Table: schedule                                              */
/*==============================================================*/
CREATE TABLE SCHEDULE
(
   sched_id             INT NOT NULL AUTO_INCREMENT,
   studio_id            INT,
   play_id              INT,
   sched_time           VARCHAR(10) NOT NULL,
   sched_ticket_price   NUMERIC(10,2),
   PRIMARY KEY (sched_id)
);

/*==============================================================*/
/* Table: seat                                                  */
/*==============================================================*/
CREATE TABLE seat
(
   seat_id              INT NOT NULL AUTO_INCREMENT,
   studio_id            INT,
   seat_row             INT,
   seat_column          INT,
   PRIMARY KEY (seat_id)
);

/*==============================================================*/
/* Table: studio                                                */
/*==============================================================*/
CREATE TABLE studio
(
   studio_id            INT NOT NULL AUTO_INCREMENT,
   studio_name          VARCHAR(100) NOT NULL,
   studio_row_count     INT,
   studio_col_count     INT,
   studio_introduction  VARCHAR(2000),
   PRIMARY KEY (studio_id)
);

/*==============================================================*/
/* Table: ticket                                                */
/*==============================================================*/
CREATE TABLE ticket
(
   ticket_id            BIGINT NOT NULL AUTO_INCREMENT,
   seat_id              INT,
   sched_id             INT,
   ticket_price         NUMERIC(10,2),
   ticket_status        SMALLINT COMMENT '�������£�
            0��������
            1������
            9������',
   ticket_locked_time   VARCHAR(10),
   PRIMARY KEY (ticket_id)
);


ALTER TABLE sale ADD CONSTRAINT FK_employee_sale FOREIGN KEY (emp_id)
      REFERENCES employee (emp_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE sale_item ADD CONSTRAINT FK_sale_sale_item FOREIGN KEY (sale_ID)
      REFERENCES sale (sale_ID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE sale_item ADD CONSTRAINT FK_ticket_sale_item FOREIGN KEY (ticket_id)
      REFERENCES ticket (ticket_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE SCHEDULE ADD CONSTRAINT FK_play_sched FOREIGN KEY (play_id)
      REFERENCES play (play_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE SCHEDULE ADD CONSTRAINT FK_studio_sched FOREIGN KEY (studio_id)
      REFERENCES studio (studio_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE seat ADD CONSTRAINT FK_studio_seat FOREIGN KEY (studio_id)
      REFERENCES studio (studio_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE ticket ADD CONSTRAINT FK_sched_ticket FOREIGN KEY (sched_id)
      REFERENCES SCHEDULE (sched_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE ticket ADD CONSTRAINT FK_seat_ticket FOREIGN KEY (seat_id)
      REFERENCES seat (seat_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE USER ADD CONSTRAINT FK_user_employee FOREIGN KEY (user_id)
      REFERENCES employee (emp_id) ON DELETE RESTRICT ON UPDATE RESTRICT;