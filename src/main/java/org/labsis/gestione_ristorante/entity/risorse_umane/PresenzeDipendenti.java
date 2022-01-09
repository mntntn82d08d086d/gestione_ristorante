package org.labsis.gestione_ristorante.entity.risorse_umane;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

/**
 * TODO: Documentazione
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PresenzeDipendenti implements Serializable {

    @EmbeddedId
    private PrezenzeDipendenteKey id;

    @MapsId("dipendenteId")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "dipendente_id", nullable = false)
    private Dipendente dipendente;

    @Column(name = "ora_entrata", nullable = false)
    private Time oraEntrata = Time.valueOf(LocalTime.now());

    @Column(name = "ora_uscita")
    private Time oraUscita = Time.valueOf(LocalTime.now());

    @Transient
    public Date getDatePresenza() {
        return id.getDataPresenza();
    }
}