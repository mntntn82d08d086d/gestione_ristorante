create table if not exists cliente
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
    constraint UK_3ls5yuv4wvj4nmpg010khvyyv
        unique (account_email, account_username),
    constraint FK4b2p3bege9thas2iu2jacy5eu
        foreign key (account_email, account_username) references account (email, username)
);

