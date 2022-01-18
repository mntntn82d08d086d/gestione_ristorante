create table if not exists ordine
(
    id             bigint      not null,
    codice_ordine  varchar(90) not null,
    data_richiesta date        not null,
    nota           longtext    null,
    ordine_evaso   bit         null,
    primary key (id),
    constraint UK_2hon109h7nb80xevt74m2ier5
        unique (codice_ordine)
);

