create table if not exists rubrica_azienda_convenzione
(
    azienda_convenzione_piva varchar(21) not null,
    contatto_id              bigint      not null,
    primary key (azienda_convenzione_piva, contatto_id),
    constraint ac_contatto_id_unique
        unique (contatto_id),
    constraint ac_contatto_id_fk
        foreign key (contatto_id) references contatto (contatto_id),
    constraint ac_piva_fk
        foreign key (azienda_convenzione_piva) references azienda_convenzione (piva)
);

create index if not exists ac_piva_idx
    on rubrica_azienda_convenzione (azienda_convenzione_piva);

