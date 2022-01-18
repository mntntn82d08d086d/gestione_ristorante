create table if not exists fornitore
(
    piva         varchar(21)  not null,
    citta        varchar(255) not null,
    nome_azienda varchar(255) not null,
    sede_legale  varchar(255) not null,
    primary key (piva),
    constraint nome_azienda_unique
        unique (nome_azienda)
);

