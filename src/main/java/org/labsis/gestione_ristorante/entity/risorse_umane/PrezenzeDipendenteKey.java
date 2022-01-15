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
public class PrezenzeDipendenteKey implements Serializable {

    @Column(name = "data_presenza", nullable = false)
    private Date dataPresenza;

    @Column(name = "dipendente_piva", nullable = false)
    private String dipendentePiva;

    public PrezenzeDipendenteKey() {
    }

    public PrezenzeDipendenteKey(Date dataPresenza, String dipendentePiva) {
        this.dataPresenza = dataPresenza;
        this.dipendentePiva = dipendentePiva;
    }

    public Date getDataPresenza() {
        return dataPresenza;
    }

    public void setDataPresenza(Date dataPresenza) {
        this.dataPresenza = dataPresenza;
    }

    public String getDipendentePiva() {
        return dipendentePiva;
    }

    public void setDipendentePiva(String dipendentePiva) {
        this.dipendentePiva = dipendentePiva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrezenzeDipendenteKey)) return false;
        PrezenzeDipendenteKey that = (PrezenzeDipendenteKey) o;
        return Objects.equal(getDataPresenza(), that.getDataPresenza()) &&
                Objects.equal(getDipendentePiva(), that.getDipendentePiva());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getDataPresenza(), getDipendentePiva());
    }

    @Override
    public String toString() {
        return "PrezenzeDipendenteKey{" +
                "dataPresenza=" + dataPresenza +
                ", dipendente piva=" + dipendentePiva +
                '}';
    }
}