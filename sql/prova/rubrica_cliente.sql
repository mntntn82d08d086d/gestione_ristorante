create table if not exists rubrica_cliente
(
    cliente_codice_fiscale varchar(16) not null,
    contatto_id            bigint      not null,
    primary key (cliente_codice_fiscale, contatto_id),
    constraint c_contatto_id_unique
        unique (contatto_id),
    constraint c_cod_fis_fk
        foreign key (cliente_codice_fiscale) references cliente (codice_fiscale),
    constraint c_contatto_id_fk
        foreign key (contatto_id) references contatto (contatto_id)
);

create index if not exists c_cod_fis_idx
    on rubrica_cliente (cliente_codice_fiscale);

