package org.labsis.gestione_ristorante.entity.risorse_umane;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;

/**
 * TODO: Documentazione
 */

@Embeddable
public class FerieDipendentiKey implements Serializable {

    @Column(name = "data_inizio", nullable = false)
    private Date dataInizio;

    @Column(name = "data_fine", nullable = false)
    private Date dataFine;

    @Column(name = "dipendente_codice_fiscale", nullable = false)
    private String dipendenteCodiceFiscale;

    public FerieDipendentiKey() {
    }

    public FerieDipendentiKey(Date dataInizio, Date dataFine, String dipendenteCodiceFiscale) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.dipendenteCodiceFiscale = dipendenteCodiceFiscale;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public String getDipendenteCodiceFiscale() {
        return dipendenteCodiceFiscale;
    }

    public void setDipendenteCodiceFiscale(String dipendenteCodiceFiscale) {
        this.dipendenteCodiceFiscale = dipendenteCodiceFiscale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FerieDipendentiKey)) return false;
        FerieDipendentiKey that = (FerieDipendentiKey) o;
        return Objects.equal(getDataInizio(), that.getDataInizio()) && Objects.equal(getDataFine(), that.getDataFine()) &&
                Objects.equal(getDipendenteCodiceFiscale(), that.getDipendenteCodiceFiscale());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getDataInizio(), getDataFine(), getDipendenteCodiceFiscale());
    }

    @Override
    public String toString() {
        return "FerieDipendentiKey{" +
                "dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", dipendente piva=" + dipendenteCodiceFiscale +
                '}';
    }
}