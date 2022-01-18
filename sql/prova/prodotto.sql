create table if not exists prodotto
(
    id        bigint       not null,
    marca     varchar(255) not null,
    nome      varchar(255) not null,
    tipologia varchar(255) not null,
    primary key (id)
);

