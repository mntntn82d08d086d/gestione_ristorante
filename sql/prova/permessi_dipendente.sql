create table if not exists permessi_dipendente
(
    data_permesso   date         not null,
    dipendente_piva varchar(255) not null,
    motivazione     varchar(255) not null,
    retribuito      bit          not null,
    primary key (data_permesso, dipendente_piva),
    constraint FKdowl0a2m4drvq2m3yq3sywuq9
        foreign key (dipendente_piva) references dipendente (codice_fiscale)
);

