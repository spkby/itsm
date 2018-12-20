--liquibase formatted sql

--changeset taniaAzar:create-table1

DROP TABLE IF EXISTS `patients`;
CREATE TABLE patients(
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  phone varchar(50) NOT NULL,
  state_id int NOT NULL REFERENCES states (id)
);
--rollback drop table patients;

--changeset taniaAzar:create-table2

DROP TABLE IF EXISTS `users`;
CREATE TABLE users(
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  email varchar(50) NOT NULL,
  login varchar(50) NOT NULL,
  password varchar(80) NOT NULL
);
--rollback drop table users;

--changeset taniaAzar:create-table3

DROP TABLE IF EXISTS `states`;
CREATE TABLE states(
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  code varchar(10) NOT NULL,
  name varchar (50) NOT NULL
);
--rollback drop table states;


--changeset taniaAzar:create-table4

DROP TABLE IF EXISTS `products`;
CREATE TABLE products(
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name varchar (50) NOT NULL,
  state_id int NOT NULL REFERENCES states (id)
);
--rollback drop table products;


--changeset taniaAzar:create-table5

DROP TABLE IF EXISTS `transaction`;
CREATE TABLE transaction(
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  patient_id int NOT NULL REFERENCES patients (id),
  product_id int NOT NULL REFERENCES products (id),
  date DATETIME NOT NULL
);
--rollback drop table transaction;

--changeset taniaAzar:create-table6

DROP TABLE IF EXISTS `audit`;
CREATE TABLE audit(
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  date DATETIME NOT NULL,
  status bit(1) NOT NULL,
  action varchar (1000) NOT NULL
);
--rollback drop table audit;


--changeset taniaAzar:date-for-states1
INSERT INTO states (id,code,name) VALUES (1,'NV','Nevada');
INSERT INTO states (id,code,name) VALUES (2,'NY','New York');
INSERT INTO states (id,code,name) values (3,'FL','Florida');

--rollback delete from states;