create table user (
    id bigint(20) not null AUTO_INCREMENT,
    name varchar(255) default null
) engine=InnoDB charset=utf8 row_format=DYNAMIC;