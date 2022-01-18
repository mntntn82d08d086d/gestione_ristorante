create table if not exists rubrica_fornitore
(
    fornitore_piva varchar(21) not null,
    contatto_id    bigint      not null,
    primary key (fornitore_piva, contatto_id),
    constraint f_contatto_id_unique
        unique (contatto_id),
    constraint f_contatto_id_fk
        foreign key (contatto_id) references contatto (contatto_id),
    constraint f_piva_fk
        foreign key (fornitore_piva) references fornitore (piva)
);

create index if not exists f_piva_idx
    on rubrica_fornitore (fornitore_piva);

