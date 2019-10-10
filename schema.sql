DROP DATABASE IF EXISTS ssmdemo;
CREATE DATABASE ssmdemo;
USE ssmdemo;

DROP TABLE IF EXISTS tb_user;
CREATE TABLE tb_user (
id int(10) NOT NULL AUTO_INCREMENT,
user_name varchar(32) DEFAULT NULL,
password varchar(32) DEFAULT NULL,
name varchar(32) DEFAULT NULL,
age int(10) DEFAULT NULL,
sex int(2) DEFAULT NULL,
birthday date DEFAULT NULL,
created datetime DEFAULT NULL,
updated datetime DEFAULT NULL,
PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tb_user ( user_name, password, name, age, sex, birthday, created, updated) VALUES ( "zpc", "123456", "鹏程", "22", "1", "1990-09-02", sysdate(), sysdate());
INSERT INTO tb_user ( user_name, password, name, age, sex, birthday, created, updated) VALUES ( "hj", "123456", "静静", "22", "1", "1993-09-05", sysdate(), sysdate());