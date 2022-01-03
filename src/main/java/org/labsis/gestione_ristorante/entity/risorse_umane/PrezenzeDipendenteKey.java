package org.labsis.gestione_ristorante.entity.risorse_umane;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;

/**
 * TODO: Documentazione
 */

@Embeddable
public class PrezenzeDipendenteKey implements Serializable {

    @Column(name = "data_presenza", nullable = false)
    private Date dataPresenza;

    @Column(name = "dipendente_id", nullable = false)
    private Long dipendenteId;

    public PrezenzeDipendenteKey() {
    }

    public PrezenzeDipendenteKey(Date dataPresenza, Long dipendenteId) {
        this.dataPresenza = dataPresenza;
        this.dipendenteId = dipendenteId;
    }

    public Date getDataPresenza() {
        return dataPresenza;
    }

    public void setDataPresenza(Date dataPresenza) {
        this.dataPresenza = dataPresenza;
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
        if (!(o instanceof PrezenzeDipendenteKey)) return false;

        PrezenzeDipendenteKey that = (PrezenzeDipendenteKey) o;

        if (!getDataPresenza().equals(that.getDataPresenza())) return false;
        return getDipendenteId().equals(that.getDipendenteId());
    }

    @Override
    public int hashCode() {
        int result = getDataPresenza().hashCode();
        result = 3 * result + getDipendenteId().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PrezenzeDipendenteKey{" +
                "dataPresenza=" + dataPresenza +
                ", dipendenteId=" + dipendenteId +
                '}';
    }
}