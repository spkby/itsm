-
-
liquibase
formatted
sql

-
-
changeset
vlaship
:
4

alter table patient
  add created_on datetime;

alter table patient
  add created_by int;

alter table patient
  add updated_on datetime;

alter table patient
  add updated_by int;


alter table product
  add created_on datetime;

alter table product
  add created_by int;

alter table product
  add updated_on datetime;

alter table product
  add updated_by int;

rename table productsale to sale;

alter table sale
  add created_on datetime;

alter table sale
  add created_by int;

alter table sale
  add updated_on datetime;

alter table sale
  add updated_by int;