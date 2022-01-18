create table if not exists socio
(
    codice_fiscale   varchar(16)  not null,
    citta            varchar(255) null,
    cognome          varchar(90)  not null,
    data_di_nascita  date         null,
    indirizzo        varchar(255) null,
    nome             varchar(90)  not null,
    account_email    varchar(90)  not null,
    account_username varchar(90)  not null,
    primary key (codice_fiscale),
    constraint UK_47lhsej4o52nkgh82jylgbaf1
        unique (account_email, account_username),
    constraint FKpr1cdvmyqg6p8ceq967pemkol
        foreign key (account_email, account_username) references account (email, username)
);

