package org.labsis.gestione_ristorante.entity.risorse_umane;

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

    @Column(name = "dipendente_id", nullable = false)
    private Long dipendenteId;

    public FerieDipendentiKey() {
    }

    public FerieDipendentiKey(Date dataInizio, Date dataFine, Long dipendenteId) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.dipendenteId = dipendenteId;
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

    public Long getDipendenteId() {
        return dipendenteId;
    }

    public void setDipendenteId(Long dipendenteId) {
        this.dipendenteId = dipendenteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FerieDipendentiKey)) return false;

        FerieDipendentiKey that = (FerieDipendentiKey) o;

        if (!getDataInizio().equals(that.getDataInizio())) return false;
        if (!getDataFine().equals(that.getDataFine())) return false;
        return getDipendenteId().equals(that.getDipendenteId());
    }

    @Override
    public int hashCode() {
        int result = getDataInizio().hashCode();
        result = 31 * result + getDataFine().hashCode();
        result = 31 * result + getDipendenteId().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "FerieDipendentiKey{" +
                "dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", dipendenteId=" + dipendenteId +
                '}';
    }
}