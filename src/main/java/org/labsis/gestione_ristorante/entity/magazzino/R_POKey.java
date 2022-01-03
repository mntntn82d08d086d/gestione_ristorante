package org.labsis.gestione_ristorante.entity.magazzino;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * TODO: Documentazione
 */

@Embeddable
public class R_POKey implements Serializable {

    @Column(name = "prodotto_id")
    protected Long prodottoId;

    @Column(name = "ordine_id")
    protected Long ordineId;

    public R_POKey() {
    }

    public R_POKey(Long prodottoId, Long ordineId) {
        this.prodottoId = prodottoId;
        this.ordineId = ordineId;
    }

    public Long getProdottoId() {
        return prodottoId;
    }

    public void setProdottoId(Long prodottoId) {
        this.prodottoId = prodottoId;
    }

    public Long getOrdineId() {
        return ordineId;
    }

    public void setOrdineId(Long ordineId) {
        this.ordineId = ordineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof R_POKey)) return false;

        R_POKey r_poKey = (R_POKey) o;

        if (!getProdottoId().equals(r_poKey.getProdottoId())) return false;
        return getOrdineId().equals(r_poKey.getOrdineId());
    }

    @Override
    public int hashCode() {
        int result = getProdottoId().hashCode();
        result = 31 * result + getOrdineId().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "R_POKey{" +
                "prodottoId=" + prodottoId +
                ", ordineId=" + ordineId +
                '}';
    }
}