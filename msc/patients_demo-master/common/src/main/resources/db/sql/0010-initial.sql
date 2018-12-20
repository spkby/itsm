-- liquibase formatted sql

-- changeset vpispanen:initial-structure_1
CREATE TABLE patient (
  id int NOT NULL AUTO_INCREMENT,
  phone varchar(45) NOT NULL,
  state_id int NOT NULL,
  UNIQUE KEY Unique_Patient_Phone (phone),
  PRIMARY KEY (id)
);


-- changeset vpispanen:initial-structure-2
CREATE TABLE state (
  id int NOT NULL AUTO_INCREMENT,
  code char(2) NOT NULL,
  `name` varchar(30) NOT NULL,
  UNIQUE KEY Unique_State_Name (`name`),
  UNIQUE KEY Unique_State_Code (code),
  PRIMARY KEY (id)
);

-- changeset vpispanen:initial-structure-3
CREATE TABLE audit (
  id int NOT NULL AUTO_INCREMENT,
  data varchar(2000) NOT NULL,
  date DATETIME NOT NULL,
  success bit(1) NOT NULL,
  PRIMARY KEY (id)
);

-- changeset vpispanen:initial-structure_4
CREATE TABLE product (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  state_id int NOT NULL,
  UNIQUE KEY Unique_Product_Name (name),
  PRIMARY KEY (id)
);

-- changeset vpispanen:initial-structure-5
ALTER TABLE patient ADD CONSTRAINT FK_PAT_STATE FOREIGN KEY (state_id) REFERENCES state (id);


-- changeset vpispanen:initial-structure-6
ALTER TABLE product ADD CONSTRAINT FK_PRD_STATE FOREIGN KEY (state_id) REFERENCES state (id);

-- changeset vpispanen:initial-structure_7
CREATE TABLE product_sale (
  id int NOT NULL AUTO_INCREMENT,
  patient_id int NOT NULL,
  product_id int NOT NULL,
  date DATETIME NOT NULL,
  PRIMARY KEY (id)
);

-- changeset vpispanen:initial-structure-8
ALTER TABLE product_sale ADD CONSTRAINT FK_PRD_SALE_PAT FOREIGN KEY (patient_id) REFERENCES patient (id);


-- changeset vpispanen:initial-structure-9
ALTER TABLE product_sale ADD CONSTRAINT FK_PRD_SALE_PRD FOREIGN KEY (product_id) REFERENCES product (id);

-- changeset vpispanen:initial-data-1
INSERT INTO state VALUES
(1,'AL', 'Alabama'),
(2,'AK', 'Alaska'),
(3,'AZ', 'Arizona'),
(4,'CA', 'California'),
(5,'NY', 'New York');
