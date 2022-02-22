package org.labsis.gestione_ristorante.entity.risorse_umane;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * TODO: Documentazione
 */

@Entity
public class FerieDipendenti implements Serializable {

    @EmbeddedId
    private FerieDipendentiKey id;

    @MapsId("dipendenteCodiceFiscale")
    @ManyToOne(optional = false)
    @JoinColumn(name = "dipendente_codice_fiscale",nullable = false)
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
    public String getDipendenteCodiceFiscale() {
        return id.getDipendenteCodiceFiscale();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FerieDipendenti)) return false;
        FerieDipendenti that = (FerieDipendenti) o;
        return Objects.equal(getId(), that.getId()) && Objects.equal(getDipendente(), that.getDipendente());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getDipendente());
    }

    @Override
    public String toString() {
        return "FerieDipendenti{" +
                "id=" + id +
                ", dipendente=" + dipendente +
                '}';
    }
}