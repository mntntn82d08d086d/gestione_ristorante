create table if not exists user_roles
(
    user_name varchar(255) not null,
    roles_id  bigint       not null,
    constraint FKe234ryjw418hdv8r55jea27ig
        foreign key (user_name) references user (name),
    constraint FKj9553ass9uctjrmh0gkqsmv0d
        foreign key (roles_id) references role (id)
);

