package org.labsis.gestione_ristorante.entity.risorse_umane;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

/**
 * TODO: Documentazione
 */

@Entity
public class PresenzeDipendenti implements Serializable {

    @EmbeddedId
    private PrezenzeDipendenteKey id;

    @MapsId("dipendentePiva")
    @ManyToOne(optional = false)
    @JoinColumn(name = "dipendente_piva", nullable = false)
    private Dipendente dipendente;

    @Column(name = "ora_entrata", nullable = false)
    private Time oraEntrata = Time.valueOf(LocalTime.now());

    @Column(name = "ora_uscita")
    private Time oraUscita = Time.valueOf(LocalTime.now());

    public PresenzeDipendenti() {
    }

    public PresenzeDipendenti(PrezenzeDipendenteKey id, Dipendente dipendente, Time oraEntrata, Time oraUscita) {
        this.id = id;
        this.dipendente = dipendente;
        this.oraEntrata = oraEntrata;
        this.oraUscita = oraUscita;
    }

    @Transient
    public Date getDatePresenza() {
        return id.getDataPresenza();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PresenzeDipendenti)) return false;
        PresenzeDipendenti that = (PresenzeDipendenti) o;
        return Objects.equal(id, that.id) && Objects.equal(dipendente, that.dipendente) && Objects.equal(oraEntrata, that.oraEntrata) && Objects.equal(oraUscita, that.oraUscita);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, dipendente, oraEntrata, oraUscita);
    }

    @Override
    public String toString() {
        return "PresenzeDipendenti{" +
                "id=" + id +
                ", dipendente=" + dipendente +
                ", oraEntrata=" + oraEntrata +
                ", oraUscita=" + oraUscita +
                '}';
    }
}