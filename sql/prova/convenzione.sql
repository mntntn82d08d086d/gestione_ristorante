create table if not exists convenzione
(
    id                 bigint      not null,
    codice_convenzione varchar(15) not null,
    data_stipula       date        not null,
    sconto             double      not null,
    primary key (id)
);

