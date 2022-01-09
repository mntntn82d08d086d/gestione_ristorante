package org.labsis.gestione_ristorante.entity.risorse_umane;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;

/**
 * TODO: Documentazione
 */

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FerieDipendentiKey implements Serializable {

    @Column(name = "data_inizio", nullable = false)
    private Date dataInizio;

    @Column(name = "data_fine", nullable = false)
    private Date dataFine;

    @Column(name = "dipendente_id", nullable = false)
    private Long dipendenteId;

}