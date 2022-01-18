create table if not exists user
(
    name     varchar(255) not null,
    password varchar(255) null,
    username varchar(255) null,
    primary key (name)
);

