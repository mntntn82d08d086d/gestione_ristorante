package org.labsis.gestione_ristorante.entity.gestione_pagamenti;

import lombok.*;
import org.labsis.gestione_ristorante.entity.admin.Socio;
import org.labsis.gestione_ristorante.entity.magazzino.Ordine;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * TODO: Documentazione
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R_OS implements Serializable {

    @EmbeddedId
    private R_OSkey id;

    @MapsId("ordineId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "ordine_id", nullable = false)
    private Ordine ordine;

    @MapsId("socioId")
    @JoinColumn(name = "socio_id", nullable = false)
    @ManyToOne(optional = false)
    private Socio socio;

    @Column(name = "data_evasione", nullable = false)
    private Date dataEvasione;

}