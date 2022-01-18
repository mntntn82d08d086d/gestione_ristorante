create table if not exists ferie_dipendenti
(
    data_fine       date         not null,
    data_inizio     date         not null,
    dipendente_piva varchar(255) not null,
    primary key (data_fine, data_inizio, dipendente_piva),
    constraint FKt5ckr7nvo9dfwoieb70kooql
        foreign key (dipendente_piva) references dipendente (codice_fiscale)
);

