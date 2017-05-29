create table user (
	  userid bigint not null primary key auto_increment,
    name varchar(255) null,
    password varchar(255) null,
    fullname varchar(300) null,
    createddate timestamp null
);

create table role (
	roleid bigint not null primary key,
    name varchar(100) null
);