package org.labsis.gestione_ristorante.entity.gestione_pagamenti;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * TODO: Documentazione
 */

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R_OSkey implements Serializable {

    @Column(name = "ordine_id", nullable = false)
    private Long ordineId;

    @Column(name = "socio_id", nullable = false)
    private Long socioId;

}