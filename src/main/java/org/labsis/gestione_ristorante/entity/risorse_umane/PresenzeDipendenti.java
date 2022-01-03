package org.labsis.gestione_ristorante.entity.risorse_umane;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

/**
 * TODO: Documentazione
 */

@Entity(name = "PresenzeDipendenti")
@Table(name = "presenze_dipendenti")
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

    public PresenzeDipendenti() {
    }

    public PresenzeDipendenti(PrezenzeDipendenteKey id, Dipendente dipendente, Time oraEntrata, Time oraUscita) {
        this.id = id;
        this.dipendente = dipendente;
        this.oraEntrata = oraEntrata;
        this.oraUscita = oraUscita;
    }

    public PrezenzeDipendenteKey getId() {
        return id;
    }

    public void setId(PrezenzeDipendenteKey id) {
        this.id = id;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    public Time getOraEntrata() {
        return oraEntrata;
    }

    public void setOraEntrata(Time oraEntrata) {
        this.oraEntrata = oraEntrata;
    }

    public Time getOraUscita() {
        return oraUscita;
    }

    public void setOraUscita(Time oraUscita) {
        this.oraUscita = oraUscita;
    }

    @Transient
    public Date getDatePresenza() {
        return id.getDataPresenza();
    }

    @Transient
    public Long getDipendenteId() {
        return id.getDipendenteId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PresenzeDipendenti)) return false;

        PresenzeDipendenti that = (PresenzeDipendenti) o;

        if (!getId().equals(that.getId())) return false;
        if (!getDipendente().equals(that.getDipendente())) return false;
        if (!getOraEntrata().equals(that.getOraEntrata())) return false;
        return getOraUscita() != null ? getOraUscita().equals(that.getOraUscita()) : that.getOraUscita() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 3 * result + getDipendente().hashCode();
        result = 5 * result + getOraEntrata().hashCode();
        result = 7 * result + (getOraUscita() != null ? getOraUscita().hashCode() : 0);
        return result;
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