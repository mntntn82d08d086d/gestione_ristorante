create table if not exists azienda_convenzione
(
    piva           varchar(21)  not null,
    citta          varchar(255) not null,
    nome_azienda   varchar(255) not null,
    sede_legale    varchar(255) not null,
    prefix_tessera varchar(10)  null,
    convenzione_id bigint       null,
    primary key (piva),
    constraint convenzione_unique
        unique (convenzione_id),
    constraint nome_azienda_unique
        unique (nome_azienda),
    constraint prefix_tessera_unique
        unique (prefix_tessera),
    constraint ac_convenzione_id
        foreign key (convenzione_id) references convenzione (id)
);

