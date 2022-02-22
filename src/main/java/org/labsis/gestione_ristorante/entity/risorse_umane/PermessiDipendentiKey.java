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
public class PermessiDipendentiKey implements Serializable {

    @Column(name = "data_permesso", nullable = false)
    private Date dataPermesso;

    @Column(name = "dipendente_codice_fiscale", nullable = false)
    private String dipendenteCodiceFiscale;

    public PermessiDipendentiKey() {
    }

    public PermessiDipendentiKey(Date dataPermesso, String dipendenteCodiceFiscale) {
        this.dataPermesso = dataPermesso;
        this.dipendenteCodiceFiscale = dipendenteCodiceFiscale;
    }

    public Date getDataPermesso() {
        return dataPermesso;
    }

    public void setDataPermesso(Date dataPermesso) {
        this.dataPermesso = dataPermesso;
    }

    public String getDipendenteCodiceFiscale() {
        return dipendenteCodiceFiscale;
    }

    public void setDipendenteCodiceFiscale(String dipendentePiva) {
        this.dipendenteCodiceFiscale = dipendentePiva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PermessiDipendentiKey)) return false;
        PermessiDipendentiKey that = (PermessiDipendentiKey) o;
        return Objects.equal(getDataPermesso(), that.getDataPermesso()) &&
                Objects.equal(getDipendenteCodiceFiscale(), that.getDipendenteCodiceFiscale());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getDataPermesso(), getDipendenteCodiceFiscale());
    }

    @Override
    public String toString() {
        return "PermessiDipendentiKey{" +
                "dataPermesso=" + dataPermesso +
                ", dipendente piva=" + dipendenteCodiceFiscale +
                '}';
    }
}