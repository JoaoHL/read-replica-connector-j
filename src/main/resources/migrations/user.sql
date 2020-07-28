create table user (
    id bigint(20) not null AUTO_INCREMENT PRIMARY KEY,
    name varchar(255) default null
) engine=InnoDB charset=utf8 row_format=DYNAMIC;