create table if not exists account
(
    email    varchar(90) not null,
    username varchar(90) not null,
    password longtext    not null,
    primary key (email, username)
);

