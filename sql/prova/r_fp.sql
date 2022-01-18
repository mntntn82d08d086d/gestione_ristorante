create table if not exists r_fp
(
    fornitore_piva  varchar(255) not null,
    prodotto_id     bigint       not null,
    prezzo_unitario double       not null,
    tempo_consegna  int          not null,
    primary key (fornitore_piva, prodotto_id),
    constraint FK1h76j9fpa9njv5q0bb3ly29pl
        foreign key (fornitore_piva) references fornitore (piva),
    constraint FKsyx265yu22djm0u4kpg76pfmt
        foreign key (prodotto_id) references prodotto (id)
);

