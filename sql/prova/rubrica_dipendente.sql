create table if not exists rubrica_dipendente
(
    dipendente_codice_fiscale varchar(16) not null,
    contatto_id               bigint      not null,
    primary key (dipendente_codice_fiscale, contatto_id),
    constraint d_contatto_id_unique
        unique (contatto_id),
    constraint d_cod_fis_fk
        foreign key (dipendente_codice_fiscale) references dipendente (codice_fiscale),
    constraint d_contatto_id_fk
        foreign key (contatto_id) references contatto (contatto_id)
);

create index if not exists d_cod_fis_idx
    on rubrica_dipendente (dipendente_codice_fiscale);

