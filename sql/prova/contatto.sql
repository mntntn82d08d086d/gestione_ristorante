create table if not exists contatto
(
    contatto_id bigint      not null,
    contatto    varchar(50) not null,
    suffix      varchar(20) null,
    tipologia   varchar(20) not null,
    primary key (contatto_id)
);

