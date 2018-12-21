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
3

create table user
(
  id   int auto_increment,
  name varchar(20)  not null,
  hash varchar(255) not null,
  constraint user_pk
    primary key (id)
);

create unique index user_name_uindex
  on user (name);