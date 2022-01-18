create table if not exists dipendente
(
    codice_fiscale        varchar(16)  not null,
    citta                 varchar(255) null,
    cognome               varchar(90)  not null,
    data_di_nascita       date         null,
    indirizzo             varchar(255) null,
    nome                  varchar(90)  not null,
    ferie_da_contratto    int          not null,
    mansione              varchar(20)  not null,
    permessi_da_contratto int          not null,
    account_email         varchar(90)  not null,
    account_username      varchar(90)  not null,
    primary key (codice_fiscale),
    constraint UK_ne89e70oi3hga870w0lac3d74
        unique (account_email, account_username),
    constraint FKdmrl1pgcuttkcg5hoxph6uso7
        foreign key (account_email, account_username) references account (email, username)
);

