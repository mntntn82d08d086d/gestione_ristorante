package org.labsis.gestione_ristorante.entity.magazzino;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * TODO: Documentazione
 */

@Embeddable
public class R_FPKey implements Serializable {

    @Column(name = "fornitore_id", nullable = false)
    private Long fornitoreId;

    @Column(name = "prodotto_id", nullable = false)
    private Long prodottoId;

    public R_FPKey() {
    }

    public R_FPKey(Long fornitoreId, Long prodottoId) {
        this.fornitoreId = fornitoreId;
        this.prodottoId = prodottoId;
    }

    public Long getFornitoreId() {
        return fornitoreId;
    }

    public void setFornitoreId(Long fornitoreId) {
        this.fornitoreId = fornitoreId;
    }

    public Long getProdottoId() {
        return prodottoId;
    }

    public void setProdottoId(Long prodottoId) {
        this.prodottoId = prodottoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof R_FPKey)) return false;

        R_FPKey r_fpKey = (R_FPKey) o;

        if (!getFornitoreId().equals(r_fpKey.getFornitoreId())) return false;
        return getProdottoId().equals(r_fpKey.getProdottoId());
    }

    @Override
    public int hashCode() {
        int result = getFornitoreId().hashCode();
        result = 31 * result + getProdottoId().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "R_FPKey{" +
                "fornitoreId=" + fornitoreId +
                ", prodottoId=" + prodottoId +
                '}';
    }
}
