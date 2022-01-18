create table if not exists presenze_dipendenti
(
    data_presenza   date         not null,
    dipendente_piva varchar(255) not null,
    ora_entrata     time         not null,
    ora_uscita      time         null,
    primary key (data_presenza, dipendente_piva),
    constraint FKlmk5yrvko7jmlx10wghkhqsee
        foreign key (dipendente_piva) references dipendente (codice_fiscale)
);

