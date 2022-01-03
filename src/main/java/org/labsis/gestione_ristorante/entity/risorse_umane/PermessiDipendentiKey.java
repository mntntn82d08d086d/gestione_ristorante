package org.labsis.gestione_ristorante.entity.risorse_umane;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;

/**
 * TODO: Documentazione
 */

@Embeddable
public class PermessiDipendentiKey implements Serializable {

    @Column(name = "data_permesso", nullable = false)
    private Date dataPermesso;

    @Column(name = "dipendente_id", nullable = false)
    private Long dipendenteId;

    public PermessiDipendentiKey() {
    }

    public PermessiDipendentiKey(Date dataPermesso, Long dipendenteId) {
        this.dataPermesso = dataPermesso;
        this.dipendenteId = dipendenteId;
    }

    public Date getDataPermesso() {
        return dataPermesso;
    }

    public void setDataPermesso(Date dataPermesso) {
        this.dataPermesso = dataPermesso;
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
        if (!(o instanceof PermessiDipendentiKey)) return false;

        PermessiDipendentiKey that = (PermessiDipendentiKey) o;

        if (!getDataPermesso().equals(that.getDataPermesso())) return false;
        return getDipendenteId().equals(that.getDipendenteId());
    }

    @Override
    public int hashCode() {
        int result = getDataPermesso().hashCode();
        result = 31 * result + getDipendenteId().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PermessiDipendentiKey{" +
                "dataPermesso=" + dataPermesso +
                ", dipendenteId=" + dipendenteId +
                '}';
    }
}