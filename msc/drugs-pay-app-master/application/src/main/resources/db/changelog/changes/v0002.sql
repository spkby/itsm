CREATE TABLE car(
  car_id       BIGINT(20)  NOT NULL   AUTO_INCREMENT,
  car_name     VARCHAR(32) NOT NULL,
  PRIMARY KEY (car_id)
);
insert into car (car_name) values
('IT'),
('HR');
INSERT INTO db_transaction (Dtr_Dpi_Patient, Dtr_Dpr_Product, Dtr_Date) VALUES
  (1, 1, '2000-01-01'),
  (1, 1, '2000-01-01'),
  (1, 1, '2000-01-01'),
  (1, 1, '2000-01-01'),
  (1, 2, '2000-01-01'),
  (1, 2, '2000-01-01'),
  (1, 2, '2000-01-01'),
  (2, 1, '1998-01-01'),
  (2, 2, '2001-01-01'),
  (2, 3, '2000-01-01'),
  (2, 1, '1999-01-01'),
  (2, 2, '2003-01-01');