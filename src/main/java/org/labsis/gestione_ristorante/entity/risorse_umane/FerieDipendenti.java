package org.labsis.gestione_ristorante.entity.risorse_umane;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * TODO: Documentazione
 */

@Entity(name = "FerieDipendenti")
@Table(name = "ferie_dipendenti")
public class FerieDipendenti implements Serializable {

    @EmbeddedId
    private FerieDipendentiKey id;

    @MapsId("dipendenteId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "dipendente_id",nullable = false)
    private Dipendente dipendente;

    public FerieDipendenti() {
    }

    public FerieDipendenti(FerieDipendentiKey id, Dipendente dipendente) {
        this.id = id;
        this.dipendente = dipendente;
    }

    public FerieDipendentiKey getId() {
        return id;
    }

    public void setId(FerieDipendentiKey id) {
        this.id = id;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    @Transient
    public Date getDataInizio() {
        return id.getDataInizio();
    }

    @Transient
    public Date getDataFine() {
        return id.getDataFine();
    }

    @Transient
    public Long getDipendenteId() {
        return id.getDipendenteId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FerieDipendenti)) return false;

        FerieDipendenti that = (FerieDipendenti) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        return getDipendente() != null ? getDipendente().equals(that.getDipendente()) : that.getDipendente() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDipendente() != null ? getDipendente().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FerieDipendenti{" +
                "id=" + id +
                ", dipendente=" + dipendente +
                '}';
    }
}