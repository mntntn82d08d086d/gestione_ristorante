create table if not exists r_po
(
    ordine_id   bigint not null,
    prodotto_id bigint not null,
    quantita    double not null,
    primary key (ordine_id, prodotto_id),
    constraint FK64ic3ka6d141l8qxkorpti7eu
        foreign key (prodotto_id) references prodotto (id),
    constraint FK8gbrtexix2dojyejiys7mcvj6
        foreign key (ordine_id) references ordine (id)
);

