create table if not exists r_os
(
    ordine_id     bigint       not null,
    socio_piva    varchar(255) not null,
    data_evasione date         not null,
    primary key (ordine_id, socio_piva),
    constraint FK8a738f3j6nnfqfm0et6qg80u9
        foreign key (socio_piva) references socio (codice_fiscale),
    constraint FKac28vn5ks4au61qx1uqyqop8r
        foreign key (ordine_id) references ordine (id)
);

