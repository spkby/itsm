--liquibase formatted sql

--changeset fertigi:2

insert into states (code,name) values ('AL','Alabama');
insert into states (code,name) values ('AK','Alaska');
insert into states (code,name) values ('AZ','Arizona');
insert into states (code,name) values ('AR','Arkansas');
insert into states (code,name) values ('CA','California');
insert into states (code,name) values ('CO','Colorado');
insert into states (code,name) values ('CT','Connecticut');
insert into states (code,name) values ('DE','Delaware');
insert into states (code,name) values ('DC','District of Columbia');
insert into states (code,name) values ('FL','Florida');
insert into states (code,name) values ('GA','Georgia');
insert into states (code,name) values ('HI','Hawaii');
insert into states (code,name) values ('ID','Idaho');
insert into states (code,name) values ('IL','Illinois');
insert into states (code,name) values ('IN','Indiana');
insert into states (code,name) values ('IA','Iowa');
insert into states (code,name) values ('KS','Kansas');
insert into states (code,name) values ('KY','Kentucky');
insert into states (code,name) values ('LA','Louisiana');
insert into states (code,name) values ('ME','Maine');
insert into states (code,name) values ('MD','Maryland');
insert into states (code,name) values ('MA','Massachusetts');
insert into states (code,name) values ('MI','Michigan');
insert into states (code,name) values ('MN','Minnesota');
insert into states (code,name) values ('MS','Mississippi');
insert into states (code,name) values ('MO','Missouri');
insert into states (code,name) values ('MT','Montana');
insert into states (code,name) values ('NE','Nebraska');
insert into states (code,name) values ('NV','Nevada');
insert into states (code,name) values ('NH','New Hampshire');
insert into states (code,name) values ('NJ','New Jersey');
insert into states (code,name) values ('NM','New Mexico');
insert into states (code,name) values ('NY','New York');
insert into states (code,name) values ('NC','North Carolina');
insert into states (code,name) values ('ND','North Dakota');
insert into states (code,name) values ('OH','Ohio');
insert into states (code,name) values ('OK','Oklahoma');
insert into states (code,name) values ('OR','Oregon');
insert into states (code,name) values ('PA','Pennsylvania');
insert into states (code,name) values ('RI','Rhode Island');
insert into states (code,name) values ('SC','South Carolina');
insert into states (code,name) values ('SD','South Dakota');
insert into states (code,name) values ('TN','Tennessee');
insert into states (code,name) values ('TX','Texas');
insert into states (code,name) values ('UT','Utah');
insert into states (code,name) values ('VT','Vermont');
insert into states (code,name) values ('VA','Virginia');
insert into states (code,name) values ('WA','Washington');
insert into states (code,name) values ('WV','West Virginia');
insert into states (code,name) values ('WI','Wisconsin');
insert into states (code,name) values ('WY','Wyoming');

--rollback delete from states;