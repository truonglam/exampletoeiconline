use toeiconline;

alter table user add column roleid bigint;

alter table user add constraint fk_user_role foreign key (roleid) references role(roleid);