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
1

create table state
(
  id   int primary key,
  name varchar(20) not null,
  code char(2)     not null,
  constraint state_name_uindex
    unique (name),
  constraint state_nm_uindex
    unique (code)
)
;

create table patient
(
  id       int auto_increment
    primary key,
  phone    varchar(12) not null,
  state_id int         not null,
  constraint patient_phone_uindex
    unique (phone),
  constraint patient_state_id_fk
    foreign key (state_id) references state (id)
)
;

create table product
(
  id       int auto_increment
    primary key,
  name     varchar(10) not null,
  state_id int         not null,
  constraint product_name_uindex
    unique (name),
  constraint product_state_id_fk
    foreign key (state_id) references state (id)
)
;

create table audit
(
  id      int auto_increment
    primary key,
  date    datetime   not null,
  success tinyint(1) not null,
  action  text       not null
)
;

create table productsale
(
  id         int auto_increment
    primary key,
  patient_id int      not null,
  product_id int      not null,
  date       datetime not null,
  constraint transaction_patient_id_fk
    foreign key (patient_id) references patient (id),
  constraint transaction_product_id_fk
    foreign key (product_id) references product (id)
)
;

-
-
rollback drop schema medicines;

