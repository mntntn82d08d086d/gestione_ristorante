package org.labsis.gestione_ristorante.entity.risorse_umane;

import lombok.*;

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
public class FerieDipendenti implements Serializable {

    @EmbeddedId
    private FerieDipendentiKey id;

    @MapsId("dipendenteId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "dipendente_id",nullable = false)
    private Dipendente dipendente;

    @Transient
    public Date getDataInizio() {
        return id.getDataInizio();
    }

    @Transient
    public Date getDataFine() {
        return id.getDataFine();
    }

}