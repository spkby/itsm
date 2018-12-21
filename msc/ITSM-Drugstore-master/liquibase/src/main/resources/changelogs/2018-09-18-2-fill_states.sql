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
2

insert into state (id, code, name)
values (51, 'DC', 'District of Columbia');

insert into state (id, code, name)
values (1, 'AL', 'Alabama');
insert into state (id, code, name)
values (2, 'AK', 'Alaska');
insert into state (id, code, name)
values (3, 'AZ', 'Arizona');
insert into state (id, code, name)
values (4, 'AR', 'Arkansas');
insert into state (id, code, name)
values (5, 'CA', 'California');
insert into state (id, code, name)
values (6, 'CO', 'Colorado');
insert into state (id, code, name)
values (7, 'CT', 'Connecticut');
insert into state (id, code, name)
values (8, 'DE', 'Delaware');
insert into state (id, code, name)
values (9, 'FL', 'Florida');
insert into state (id, code, name)
values (10, 'GA', 'Georgia');
insert into state (id, code, name)
values (11, 'HI', 'Hawaii');
insert into state (id, code, name)
values (12, 'ID', 'Idaho');
insert into state (id, code, name)
values (13, 'IL', 'Illinois');
insert into state (id, code, name)
values (14, 'IN', 'Indiana');
insert into state (id, code, name)
values (15, 'IA', 'Iowa');
insert into state (id, code, name)
values (16, 'KS', 'Kansas');
insert into state (id, code, name)
values (17, 'KY', 'Kentucky');
insert into state (id, code, name)
values (18, 'LA', 'Louisiana');
insert into state (id, code, name)
values (19, 'ME', 'Maine');
insert into state (id, code, name)
values (20, 'MD', 'Maryland');
insert into state (id, code, name)
values (21, 'MA', 'Massachusetts');
insert into state (id, code, name)
values (22, 'MI', 'Michigan');
insert into state (id, code, name)
values (23, 'MN', 'Minnesota');
insert into state (id, code, name)
values (24, 'MS', 'Mississippi');
insert into state (id, code, name)
values (25, 'MO', 'Missouri');
insert into state (id, code, name)
values (26, 'MT', 'Montana');
insert into state (id, code, name)
values (27, 'NE', 'Nebraska');
insert into state (id, code, name)
values (28, 'NV', 'Nevada');
insert into state (id, code, name)
values (29, 'NH', 'New Hampshire');
insert into state (id, code, name)
values (30, 'NJ', 'New Jersey');
insert into state (id, code, name)
values (31, 'NM', 'New Mexico');
insert into state (id, code, name)
values (32, 'NY', 'New York');
insert into state (id, code, name)
values (33, 'NC', 'North Carolina');
insert into state (id, code, name)
values (34, 'ND', 'North Dakota');
insert into state (id, code, name)
values (35, 'OH', 'Ohio');
insert into state (id, code, name)
values (36, 'OK', 'Oklahoma');
insert into state (id, code, name)
values (37, 'OR', 'Oregon');
insert into state (id, code, name)
values (38, 'PA', 'Pennsylvania');
insert into state (id, code, name)
values (39, 'RI', 'Rhode Island');
insert into state (id, code, name)
values (40, 'SC', 'South Carolina');
insert into state (id, code, name)
values (41, 'SD', 'South Dakota');
insert into state (id, code, name)
values (42, 'TN', 'Tennessee');
insert into state (id, code, name)
values (43, 'TX', 'Texas');
insert into state (id, code, name)
values (44, 'UT', 'Utah');
insert into state (id, code, name)
values (45, 'VT', 'Vermont');
insert into state (id, code, name)
values (46, 'VA', 'Virginia');
insert into state (id, code, name)
values (47, 'WA', 'Washington');
insert into state (id, code, name)
values (48, 'WV', 'West Virginia');
insert into state (id, code, name)
values (49, 'WI', 'Wisconsin');
insert into state (id, code, name)
values (50, 'WY', 'Wyoming');

-
-
rollback delete from state;