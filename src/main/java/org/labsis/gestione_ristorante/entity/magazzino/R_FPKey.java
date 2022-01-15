package org.labsis.gestione_ristorante.entity.magazzino;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * TODO: Documentazione
 */

@Embeddable
public class R_FPKey implements Serializable {

    @Column(name = "fornitore_piva",length = 21, nullable = false)
    private String fornitorePiva;

    @Column(name = "prodotto_id", nullable = false)
    private Long prodottoId;

    public R_FPKey() {
    }

    public R_FPKey(String fornitorePiva, Long prodottoId) {
        this.fornitorePiva = fornitorePiva;
        this.prodottoId = prodottoId;
    }

    public String getFornitorePiva() {
        return fornitorePiva;
    }

    public void setFornitorePiva(String fornitoreId) {
        this.fornitorePiva = fornitoreId;
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
        return Objects.equal(getFornitorePiva(), r_fpKey.getFornitorePiva()) && Objects.equal(getProdottoId(), r_fpKey.getProdottoId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getFornitorePiva(), getProdottoId());
    }

    @Override
    public String toString() {
        return "R_FPKey{" +
                "fornitoreId=" + fornitorePiva +
                ", prodottoId=" + prodottoId +
                '}';
    }
}
